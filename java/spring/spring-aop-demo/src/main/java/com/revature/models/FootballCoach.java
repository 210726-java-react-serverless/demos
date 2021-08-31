package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class FootballCoach implements Coach {

    @Value("${coach.email}")
    private String email;

    @Value("The Cafebabes")
    private String teamName;

    @Value("#{12*2}")
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
        if (teamName.equals("The Cafebabes")){
            this.teamName = teamName;
        }  else {
            throw new RuntimeException("Sorry, the team can't be renamed.");
        }
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

    @Autowired
    public void setMotivationService(MotivationService sportMotivationService) {
        this.motivationService = sportMotivationService;
    }

    @PostConstruct
    public void customInit() {
        System.out.println("FootballCoach.customInit() was invoked!");
    }

    @PreDestroy
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
