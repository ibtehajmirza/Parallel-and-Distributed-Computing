package Assignments.Assignment2.Q3_Multithreading;

public class LogProcessorTask implements Runnable {
    @Override 
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] Iteration " + i + ": Processing batch event logs...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("LogProcessor interrupted");
            }
        }
    }
}
