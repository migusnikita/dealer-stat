package ru.mail.migus_nikita.dealerstat.config;

import java.lang.invoke.MethodHandles;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

//import javax.sql.DataSource;
//
//import liquibase.integration.spring.SpringLiquibase;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ru.mail.migus_nikita.dealerstat.constant.DatabaseConstant.ENTITY_PACKAGE;

@Configuration
public class LiquibaseConfiq {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource);
        entityManager.setPackagesToScan(ENTITY_PACKAGE);
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        logger.debug("Entity manager bean initialized and ready to use.");
        return entityManager;
    }

//    @Bean
//    public SpringLiquibase liquibase() {
//        SpringLiquibase liquibase = new SpringLiquibase();
//        liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.xml");
//        liquibase.setDataSource(dataSource());
//        return liquibase;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/dealerStat?autoReconnect=true&useSSL=" +
//                "false&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval" +
//                "=true&createDatabaseIfNotExist=true");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("63202");
//        return dataSourceBuilder.build();
//    }

}
