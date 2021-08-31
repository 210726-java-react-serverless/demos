package com.revature.models;

import com.revature.services.MotivationService;

public interface Coach {

    String getDailyWorkout();
    String getMotivation();
    MotivationService getMotivationService();

}
