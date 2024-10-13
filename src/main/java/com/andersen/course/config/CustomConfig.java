package com.andersen.course.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {
    private final static Logger logger = LoggerFactory.getLogger(CustomConfig.class);

    @Bean
    @ConditionalOnProperty(name="MyConditionalBean",havingValue = "true")
    public String conditionalBean(){
        logger.info("CustomBean has been created");
        return "CustomBean";
    }
}
