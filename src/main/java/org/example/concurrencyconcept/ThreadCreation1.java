package org.example.concurrencyconcept;

class ThreadCreation extends Thread {

    @Override
    public void run() {
        for (int i=0;i<100;i++)
            System.out.println("Task1...");
    }
}

public class ThreadCreation1 {
    public static void main(String[] args) {
        ThreadCreation threadCreation = new ThreadCreation();
        threadCreation.start();
        for(int i=0;i<100;i++)
            System.out.println("Task2...");
    }
}
