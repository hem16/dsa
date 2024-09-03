package org.example.ratelimiter;

import java.util.concurrent.*;

public class RateLimiter {
    private final Semaphore semaphore;
    private final int maxPermits;
    private final TimeUnit timePeriod;
    private final ScheduledExecutorService scheduler;

    public RateLimiter(int permits, TimeUnit timePeriod) {
        this.semaphore = new Semaphore(permits);
        this.maxPermits = permits;
        this.timePeriod = timePeriod;
        this.scheduler = Executors.newScheduledThreadPool(1);
        schedulePermitReplenishment();
    }

    public boolean tryAcquire() {
        return semaphore.tryAcquire();
    }

    private void schedulePermitReplenishment() {
        scheduler.scheduleAtFixedRate(() -> {
            semaphore.release(maxPermits - semaphore.availablePermits());
        }, 1, 1, timePeriod);
    }

    public void stop() {
        scheduler.shutdownNow();
    }
}
