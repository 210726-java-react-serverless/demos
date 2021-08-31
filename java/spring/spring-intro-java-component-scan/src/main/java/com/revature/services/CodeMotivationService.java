package com.revature.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("code")
public class CodeMotivationService implements MotivationService {

    @Override
    public String provideMotivation() {
        return "Don't quit. Suffer now and live the code the rest of your life like a boss. - Someone at Revature, I'm sure";
    }

}
