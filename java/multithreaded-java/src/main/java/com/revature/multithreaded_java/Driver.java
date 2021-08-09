package com.revature.multithreaded_java;

public class Driver {

    public static void main(String[] args) {

        DeadlockExample deadlockExample = new DeadlockExample();

//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                deadlockExample.methodA();
//            }
//        };

//        Runnable r1 = () -> deadlockExample.methodA();

        Runnable r1 = deadlockExample::methodA;
        Thread t1 = new Thread(r1); // Thread state here: NEW
        t1.setName("t1"); // Thread state here: NEW
//        t1.run(); // calls the Thread.run's logic to execute within the current thread (which is 'main')
        t1.start(); // Thread state here: RUNNABLE

        Thread t2 = new Thread(deadlockExample::methodB);
        t2.setName("t2");
        t2.start();

    }
}
