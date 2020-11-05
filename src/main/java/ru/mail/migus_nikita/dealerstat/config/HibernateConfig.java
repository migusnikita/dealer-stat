package ru.mail.migus_nikita.dealerstat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement()
@ImportResource({"classpath:hibernate5Configuration.xml"})
public class HibernateConfig {
}
