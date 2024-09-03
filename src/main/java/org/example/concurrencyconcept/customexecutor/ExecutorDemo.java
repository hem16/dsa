package org.example.concurrencyconcept.customexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

    public static void main(String[] args) {

        Runnable task1 = () -> {
            for(int i=0; i < 20; i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("[" + Thread.currentThread().getName() + "] " + "Message " + i);
            }
        };

        Runnable task2 = () -> {
            for(int i=0; i < 20; i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("[" + Thread.currentThread().getName() + "] " + "Message " + i);
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(task1);
        service.execute(task2);
        service.shutdown();

    }
}
