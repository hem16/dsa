/*

package org.example;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue<T> {

    int capacity;
    private Object[] queue;
    private int count;
    private int putIdx;
    Lock lock = new ReentrantLock();
    Condition putCondition = lock.newCondition();
    Condition getCondition = lock.newCondition();
    public CustomBlockingQueue(int size){
        this.capacity = size;
        queue = new Object[capacity];
    }

    public void put(T element) {
        lock.lock();
        while(count >= capacity) {
            try {
                putCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("element data" +element);
        queue[putIdx] = element;




    }



}

class BlockingQueueExample {

    public static void main(String args[]) {
        CustomBlockingQueue<Long> blockingQueue = new CustomBlockingQueue<>(3);
        ProduceTask produceTask = new ProduceTask(blockingQueue);
        ConsumerTask consumerTask = new ConsumerTask(blockingQueue);

        Thread producerThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumerTask);
        producerThread.start();
        consumerThread.start();
    }

}

class ProduceTask implements Runnable{



    @Override
    public void run() {

        while(true) {

            Long millis = System.currentTimeMillis();
            try {
                blockingQueue.put(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ConsumerTask implements Runnable{

    private BlockingQueue blockingQueue = null;

    public ConsumerTask(BlockingQueue q){
        this.blockingQueue = q;
    }

    @Override
    public void run() {

        while(true) {

            try {
                Long millis = (Long) blockingQueue.take();
                System.out.println("take " + millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

*/
