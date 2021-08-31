package com.revature;

import com.revature.config.AppConfig;
import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDriver {

    public static void main(String[] args) {

        System.out.println("Bean the bean container...");

        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        container.registerShutdownHook();

        FootballCoach footballCoach = container.getBean("footballCoach", FootballCoach.class);
        System.out.println(footballCoach.getDailyWorkout());
        System.out.println(footballCoach.getMotivation());
        System.out.println(footballCoach.getEmail());
        System.out.println(footballCoach.getTeamName());
        footballCoach.setTeamName("Sad Name Team :(");


        container.close();

    }

}
