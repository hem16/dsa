package org.example.concurrencyconcept.customexecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPoolExcecutor {
    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] workerThread;
    private volatile boolean isRunning = true;

    public MyThreadPoolExcecutor(int noOfThreads) {
        this.taskQueue = new LinkedBlockingQueue<>();
        this.workerThread = new Thread[noOfThreads];
        int i=0;
        for (Thread t: workerThread) {
            t = new Worker("Custom Pool Thread" + ++i);
            t.start();
        }
    }

    public void execute(Runnable task) {
        if(isRunning) {
            try {
                taskQueue.put(task);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown() {
        isRunning = false;
    }

    class Worker extends Thread {
        Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            if (isRunning) {
                try {
                    taskQueue.take().run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Usage example
    public static void main(String[] args) {
        MyThreadPoolExcecutor executor = new MyThreadPoolExcecutor(10);
        executor.execute(() -> System.out.println("Task 1 executed."));
        executor.execute(() -> System.out.println("Task 2 executed."));
        executor.execute(() -> System.out.println("Task 3 executed."));

        // Add more tasks...
        executor.shutdown();
    }
   }

