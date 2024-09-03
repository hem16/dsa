package org.example.concurrencyconcept;

class Task1Class {

    public synchronized void helloTask(Task2Class t2) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello taask ...");
        t2.hiTaskFromTask2();
    }

    public synchronized  void helloTaskFromTask1() {
        System.out.println("Hi taask from Task1...");
    }

}

class Task2Class {

    public synchronized void hiTask(Task1Class t1) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello from task1 ...");
        t1.helloTaskFromTask1();
    }

    public synchronized  void hiTaskFromTask2() {
        System.out.println("Hi taask from Task2...");
    }

}

public class DeadlockDemo implements Runnable{

    Task1Class t1 = new Task1Class();
    Task2Class t2 = new Task2Class();

    @Override
    public void run() {
        t1.helloTask(t2);

    }

    void demo(){
        t2.hiTask(t1);
    }

    public static void main(String[] args) {
        DeadlockDemo deadlockDemo = new DeadlockDemo();
        Thread thread = new Thread(deadlockDemo);
        thread.start();
        deadlockDemo.demo();
    }
}
