package com.apex.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskExecutor {

    private final ExecutorService executor;

    public TaskExecutor(int poolSize) {
        this.executor = Executors.newFixedThreadPool(poolSize);
    }

    public void submit(Runnable task) {
        executor.submit(task);
    }

    public void shutdownAndAwait() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
    
}
