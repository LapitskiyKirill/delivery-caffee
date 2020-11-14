package com.gmail.kirilllapitsky.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("application.yaml")
@EnableTransactionManagement
public class JpaConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring: datasource: driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring: datasource: url"));
        dataSource.setUsername(environment.getProperty("spring: datasource: username"));
        dataSource.setPassword(environment.getProperty(" password: password"));

        return dataSource;
    }
}