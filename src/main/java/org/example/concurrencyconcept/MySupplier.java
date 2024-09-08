package org.example.concurrencyconcept;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

public class MySupplier implements Supplier<Integer> {

    @Override
    public Integer get() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    public static class PlusOne implements Function<Integer, Integer> {

        @Override
        public Integer apply(Integer x) {
            return x + 1;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(new MySupplier());
        CompletableFuture<Integer> completableFuture2 = completableFuture.thenApply(new PlusOne());
        System.out.println("completableFuture2.get() = " + completableFuture2.get());
    }
}
