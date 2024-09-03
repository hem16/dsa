package org.example.concurrencyconcept.customexecutor;

public class MyTask implements Runnable{
    @Override
    public void run() {
        int count =1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("This task is executed by" +"count" + ++count +Thread.currentThread().getName());
    }
}
