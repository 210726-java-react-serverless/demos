package com.revature.multithreaded_java.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDriver {

    public static void main(String[] args) {

        // Runnable pattern: create on-demand thread (very resource intensive)
        Thread thread = new Thread(() -> {
            System.out.printf("%s says hello world!\n", Thread.currentThread().getName());
//            throw new RuntimeException("Catch me if you can.");
        });

        try {
            thread.start();
        } catch (RuntimeException e) {
            System.out.println("Caught!");
            e.printStackTrace();
        }

//        System.out.println("This should print.");

        /*
            1. A thread is created on demand...by some developer working on the app
            2. Once the task is complete, thread is terminated/dies.
            3. Threads are expensive resources, and we should be able to reuse them if needed
            4. Runnable#run has no return value and cannot raise exceptions
         */

        /*
            Executor Pattern

                - aims to improve the use of Java thread resources
                    + by creating pools of ready-to-use thread objects
                    + Runnable tasks are given to existing threads in some pool
                    + threads remain in the pool even after the Runnable logic is complete

                - two patterns:
                    + create a pool of threads
                    + pass a task to a thread within the pool

                - Executor pattern:
                    + executor.execute(runnableTask);

                - Runnable pattern:
                    + new Thread(runnableTask);

         */

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        Runnable task_0 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.printf("task_0 is running in %s\n", Thread.currentThread().getName());
        };

        Runnable task_1 = () -> System.out.printf("task_1 is running in %s\n", Thread.currentThread().getName());
        Runnable task_2 = () -> System.out.printf("task_2 is running in %s\n", Thread.currentThread().getName());

        singleThreadExecutor.execute(task_0);
        singleThreadExecutor.execute(task_1);
        singleThreadExecutor.execute(task_2);

        ExecutorService multiThreadExecutor = Executors.newFixedThreadPool(10);
        Runnable task_3 = () -> System.out.printf("task_3 is running in %s\n", Thread.currentThread().getName());
        Runnable task_4 = () -> System.out.printf("task_4 is running in %s\n", Thread.currentThread().getName());
        Runnable task_5 = () -> System.out.printf("task_5 is running in %s\n", Thread.currentThread().getName());
        Runnable task_6 = () -> System.out.printf("task_6 is running in %s\n", Thread.currentThread().getName());

        multiThreadExecutor.execute(task_3);
        multiThreadExecutor.execute(task_4);
        multiThreadExecutor.execute(task_5);
        multiThreadExecutor.execute(task_6);

        try {
             singleThreadExecutor.shutdown();
             multiThreadExecutor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
