package org.example.concurrencyconcept.customexecutor;

public interface MyExcecutorService {
    void submit(Runnable runnable);
}
