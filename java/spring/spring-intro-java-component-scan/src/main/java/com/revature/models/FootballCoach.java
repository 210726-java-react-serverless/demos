package com.revature.models;

import com.revature.services.MotivationService;
import com.revature.services.SportMotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class FootballCoach implements Coach {

    @Value("${coach.email}") // Spring Expression Language (SpEL): Property value interpolation
    private String email;

    @Value("The Cafebabes")
    private String teamName;

    @Value("#{12*2}") // SpEL: Expression interpolation
    private int teamSize;

    private MotivationService motivationService;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public MotivationService getMotivationService() {
        return motivationService;
    }

    @Autowired // required here, due to the use of setter injection
    public void setMotivationService(MotivationService sportMotivationService) {
        this.motivationService = sportMotivationService; // Autowiring: by name
    }

    @PostConstruct // J2EE annotation equivalent to setting an init-method for this bean
    public void customInit() {
        System.out.println("FootballCoach.customInit() was invoked!");
    }

    @PreDestroy // J2EE annotation equivalent to setting a destroy-method for this bean
    public void customDestroy() {
        System.out.println("FootballCoach.customDestroy() was invoked!");
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout: Suicide runs to 40, 50, 60, 70, 80, and 100 yard lines";
    }

    @Override
    public String getMotivation() {
        return "The football coach says: " + motivationService.provideMotivation();
    }

}
