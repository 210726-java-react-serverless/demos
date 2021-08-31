package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CodeCoach implements Coach {

    private MotivationService motivationService;

    @Autowired
    public void setMotivationService(@Qualifier("code") MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend at least 45 minutes on a medium level HackerRank or LeetCode.";
    }

    @Override
    public String getMotivation() {
        return this.motivationService.provideMotivation();
    }

    @Override
    public MotivationService getMotivationService() {
        return this.motivationService;
    }
}
