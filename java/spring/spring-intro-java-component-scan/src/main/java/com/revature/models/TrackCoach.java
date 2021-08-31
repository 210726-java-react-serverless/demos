package com.revature.models;

import com.revature.services.MotivationService;
import com.revature.services.SportMotivationService;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

//    @Autowired (Field-level injection is EVIL, DON'T DO IT!; Makes this untestable without Spring)
    private MotivationService motivationService;

    public TrackCoach(SportMotivationService motivationService) {
        this.motivationService = motivationService;
    }

    @Override
    public MotivationService getMotivationService() {
        return motivationService;
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout: Run a 30-minute 5k";
    }

    @Override
    public String getMotivation() {
        return "The track coach says: " + motivationService.provideMotivation();
    }

}
