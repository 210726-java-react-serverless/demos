package com.revature.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.BaseballCoach;
import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

// This class is used for programmatic bean registration with the container (aka: ApplicationContext)
@Configuration
@ComponentScan("com.revature") // if no package string is provided, then Spring will scan the package that this class is in for components
@PropertySource("classpath:application.properties")
public class AppConfig {

    // Other bean definitions would still go here for any other components that we wanted to declare for Spring

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
