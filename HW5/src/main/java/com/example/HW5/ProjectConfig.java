package com.example.HW5;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConditionalOnClass(ConfigurationEnabler.class)
@PropertySource("classpath:application.properties")
public class ProjectConfig {

    @Bean
    @ConditionalOnProperty(
            value = "custom.configuration.enabled",
            havingValue = "true")
    User setUser() {
        User user = new User();
        user.setName("Kolya");
        return user;
    }
}
