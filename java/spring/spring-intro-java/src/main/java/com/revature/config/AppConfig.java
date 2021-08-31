package com.revature.config;


import com.revature.models.BaseballCoach;
import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

// This class is used for programmatic bean registration with the container (aka: ApplicationContext)
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${coach.email}")
    private String coachEmail;

    @Bean(name = "myCoach")
    @Scope("prototype")
    public Coach someCoach() {
        return new BaseballCoach(motivationService()); // programmatic constructor injection
    }

    @Bean
    public MotivationService motivationService() {
        return new MotivationService();
    }

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public FootballCoach footballCoach() {
        FootballCoach footballCoach = new FootballCoach();
        footballCoach.setMotivationService(motivationService()); // programmatic setter injection
        footballCoach.setTeamName("The Cafebabes");
        footballCoach.setEmail(coachEmail);
        return footballCoach;
    }

}
