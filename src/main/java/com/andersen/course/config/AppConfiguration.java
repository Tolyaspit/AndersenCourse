package com.andersen.course.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EntityScan(basePackages = {"com.andersen.course.model"})
@Configuration
@EnableTransactionManagement
public class AppConfiguration {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/my_ticket_service_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("LinCutie270102");
        return dataSource;
    }

    @Bean
    public Resource ticketJson() {
        return new ClassPathResource("tickets.json");
    }

}
