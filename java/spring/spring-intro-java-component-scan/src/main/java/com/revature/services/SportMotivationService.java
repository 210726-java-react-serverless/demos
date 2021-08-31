package com.revature.services;

import org.springframework.stereotype.Service;

/*
    Spring can scan packages to detect classes with any of the "stereotype" annotations

    Notable annotations from the stereotype package:
        - @Component
        - @Controller
        - @Service
        - @Repository

 */

@Service
public class SportMotivationService implements MotivationService {

    @Override
    public String provideMotivation() {
        // Pretend that this queries some motivational quotes API (hard coded quote for brevity)
        return "Don't quit. Suffer now and live the rest of your life like a champion. - Muhammad Ali";
    }
}
