package com.revature.models;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {

    private MotivationService motivationService;

    public BaseballCoach(MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    public MotivationService getMotivationService() {
        return motivationService;
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
