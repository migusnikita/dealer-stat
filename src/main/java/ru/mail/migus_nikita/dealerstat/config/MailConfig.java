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

    private Environment env;

    @Autowired
    public MailConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getRequiredProperty("Host"));
        mailSender.setPort(Integer.parseInt(env.getRequiredProperty("Port")));
        mailSender.setUsername(env.getRequiredProperty("email.login"));
        mailSender.setPassword(env.getRequiredProperty("email.password"));

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", env.getRequiredProperty("mail.transport.protocol"));
        properties.put("mail.smtp.auth", env.getRequiredProperty("mail.smtp.auth"));
        properties.put("mail.smtp.starttls.enable", env.getRequiredProperty("mail.smtp.starttls.enable"));
        properties.put("mail.debug", env.getRequiredProperty("mail.debug"));
        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }
}