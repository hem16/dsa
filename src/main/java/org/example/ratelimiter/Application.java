package org.example.ratelimiter;

import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) {
        int requestsPerSecond = 5;
        RateLimiter rateLimiter = new RateLimiter(requestsPerSecond, TimeUnit.SECONDS);

        // Example usage:
        for (int i = 0; i < 10; i++) {
            if (rateLimiter.tryAcquire()) {
                // Handle allowed request
                System.out.println("Request " + i + " is allowed at " + System.currentTimeMillis());
            } else {
                // Handle rejected request
                System.out.println("Request " + i + " is rejected at " + System.currentTimeMillis());
            }
        }

        rateLimiter.stop();
    }
}
