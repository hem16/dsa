package org.example;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        //create and start the tread
        Thread waitingThread = new Thread(() -> {
            System.out.println("Waiting thread for latch = " + countDownLatch);
            System.out.println("countDownLatch = " + countDownLatch);
            System.out.println("WaitingThread resumes execution after the condition is met.");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread performingThread = new Thread(() -> {
            // Simulate some processing
            System.out.println("PerformingThread is performing some processing...");
            // Signal that the condition is met by decrementing the count
            countDownLatch.countDown();
            System.out.println("PerformingThread has completed its processing.");
        });

        waitingThread.start();
        performingThread.start();
    }
}
