package com.revature.multithreaded_java;

public class DeadlockExample {

    private final Object monitorA = new Object();
    private final Object monitorB = new Object();
    private final Object monitorC = new Object();

    public void methodA() {
        synchronized (monitorA) {
            System.out.printf("[%s] is running inside of methodA()\n", Thread.currentThread().getName());
            methodB();
        }
    }

    public void methodB() {
        synchronized (monitorB) {
            System.out.printf("[%s] is running inside of methodB()\n", Thread.currentThread().getName());
            methodC();
        }
    }

    public void methodC() {
        synchronized(monitorA) {
            System.out.printf("[%s] is running inside of methodC()\n", Thread.currentThread().getName());
        }
    }

    // The monitor object holding the key to this method is the instance of DeadlockExample
    public synchronized void methodZ() {

    }

    // The monitor object holding the key to this method is the class DeadlockExample
    public static synchronized void methodY() {

    }

}
