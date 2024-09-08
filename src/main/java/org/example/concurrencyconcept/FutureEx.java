package org.example.concurrencyconcept;

import java.util.concurrent.*;

class FutureEx implements Callable<Integer> {
    @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return 1;
    }

    public static void doPerform() throws ExecutionException, InterruptedException {
        Future<Integer> future = Executors.newSingleThreadExecutor().submit(new FutureEx());
        System.out.println("future = " + future.isDone());
        System.out.println("future Result = " + future.get());
    }

    public static void main(String[] args) {
        try {
            doPerform();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
