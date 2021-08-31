package com.revature.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.MotivationService;
import com.revature.services.SportMotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("myCoach")
public class BaseballCoach implements Coach {

    private MotivationService motivationService;
    private ObjectMapper mapper;

    @Autowired // for constructor injection, this isn't even required
    public BaseballCoach(SportMotivationService motivationService, ObjectMapper mapper) {
        this.motivationService = motivationService; // Autowiring: by type
        this.mapper = mapper;
    }

    public MotivationService getMotivationService() {
        return motivationService;
    }

    public String toJson() {
        try {
            return this.mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout: Spend an hour on batting practice.";
    }

    @Override
    public String getMotivation() {
        return "The baseball coach says: " + motivationService.provideMotivation();
    }

}
