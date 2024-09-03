package org.example.concurrencyconcept;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ThreadCreation_Runnable1 {

    public static void printNumbers() {
        for (int i = 0; i < 5; i++) {
            Thread.yield();
            System.out.println("Task1..." + i);

        }

    }

    public static void printChars() {
        char[] charArray = {'a', 'b', 'c', 'd', 'e'};
        for (int i = 0; i < 5; i++) {
            Thread.yield();
            System.out.println("Task2..." + charArray[i]);

        }
    }

}

public class ThreadCreation2 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<?> futurePrintChars = service.submit(ThreadCreation_Runnable1::printChars);
        Future<?> futurePrintNums = service.submit(ThreadCreation_Runnable1::printNumbers);

        try {
            futurePrintNums.get();
            futurePrintChars.get();
        } catch (Exception ex) {
            System.out.println("ex = " + ex);
        } finally {
            service.shutdown();
        }
    }
}
