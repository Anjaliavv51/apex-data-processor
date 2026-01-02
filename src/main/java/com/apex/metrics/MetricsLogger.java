package com.apex.metrics;

import java.util.concurrent.atomic.AtomicLong;

public class MetricsLogger {

    private static final AtomicLong cacheHits = new AtomicLong(0);
    private static final AtomicLong cacheMisses = new AtomicLong(0);

    public static void recordCacheHit() {
        cacheHits.incrementAndGet();
    }

    public static void recordCacheMiss() {
        cacheMisses.incrementAndGet();
    }

    public static void logCacheStats() {
        long hits = cacheHits.get();
        long misses = cacheMisses.get();
        long total = hits + misses;

        System.out.println("Cache Hits   : " + hits);
        System.out.println("Cache Misses : " + misses);

        if (total > 0) {
            double hitRatio = (hits * 100.0) / total;
            System.out.printf("Cache Hit Ratio: %.2f%%%n", hitRatio);
        }
    }

    public static long startTimer() {
        return System.currentTimeMillis();
    }

    public static void logLatency(long startTime, String label) {
        long duration = System.currentTimeMillis() - startTime;
        System.out.println(label + " Execution Time: " + duration + " ms");
    }
}
