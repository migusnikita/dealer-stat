package ru.mail.migus_nikita.dealerstat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource(value = "classpath:mail.properties")
public class MailConfig {

    private Environment environment;

    @Autowired
    public MailConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getRequiredProperty("Host"));
        mailSender.setPort(Integer.parseInt(environment.getRequiredProperty("Port")));
        mailSender.setUsername(environment.getRequiredProperty("email.login"));
        mailSender.setPassword(environment.getRequiredProperty("email.password"));

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", environment.getRequiredProperty("mail.transport.protocol"));
        properties.put("mail.smtp.auth", environment.getRequiredProperty("mail.smtp.auth"));
        properties.put("mail.smtp.starttls.enable", environment.getRequiredProperty("mail.smtp.starttls.enable"));
        properties.put("mail.debug", environment.getRequiredProperty("mail.debug"));
        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }
}