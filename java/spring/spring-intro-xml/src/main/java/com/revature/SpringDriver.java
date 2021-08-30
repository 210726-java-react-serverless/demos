package com.revature;

import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDriver {

    public static void main(String[] args) {

        System.out.println("Bean the bean container...");

        try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans.xml")) {

            System.out.println("Bean container created!");

            // Retrieve a bean from the container with the name "myCoach"
            Coach coach = container.getBean("myCoach", Coach.class);

            // Call some methods on the retrieved bean to ensure it is configured properly
            System.out.println(coach.getDailyWorkout());
            System.out.println(coach.getMotivation());

            // --------------------------------------------------------------------------

            Coach assistantCoach = container.getBean("myCoach", Coach.class);
            System.out.println(coach == assistantCoach);
            System.out.println(coach.getMotivationService() == assistantCoach.getMotivationService());

            // --------------------------------------------------------------------------

            FootballCoach footballCoach = container.getBean("footballCoach", FootballCoach.class);
            System.out.println(footballCoach.getDailyWorkout());
            System.out.println(footballCoach.getMotivation());
            System.out.println(footballCoach.getEmail());
            System.out.println(footballCoach.getTeamName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
