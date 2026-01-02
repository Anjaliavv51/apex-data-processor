/* 
package com.apex;

import com.apex.cache.LRUCache;
import com.apex.concurrency.TaskExecutor;
import com.apex.metrics.MetricsLogger;
import com.apex.model.Profile;
import com.apex.processor.ProfileProcessor;
import com.apex.repository.InMemoryProfileRepository;
import com.apex.repository.ProfileRepository;

import java.util.Random;

public class MainApplication {

    public static void main(String[] args) {

        // 1️⃣ Bootstrap core components
        ProfileRepository repository = new InMemoryProfileRepository();
        LRUCache<Integer, Profile> cache = new LRUCache<>(100);
        ProfileProcessor processor = new ProfileProcessor(repository, cache);

        int poolSize = Runtime.getRuntime().availableProcessors();
        TaskExecutor executor = new TaskExecutor(poolSize);

        // 2️⃣ Preload 500 profiles
        for (int i = 1; i <= 500; i++) {
            repository.save(new Profile(i, "User-" + i));
        }

        // 3️⃣ Simulate concurrent access
        Random random = new Random();
        long startTime = MetricsLogger.startTimer();

        for (int i = 0; i < 500; i++) {
            executor.submit(() -> {
                int profileId = random.nextInt(500) + 1;
                Profile profile = processor.process(profileId);

                if (profile != null) {
                    MetricsLogger.recordCacheHit();
                } else {
                    MetricsLogger.recordCacheMiss();
                }
            });
        }

        // 4️⃣ Shutdown executor
        executor.shutdownAndAwait();

        // 5️⃣ Log metrics
        MetricsLogger.logLatency(startTime, "Apex Data Processor");
        MetricsLogger.logCacheStats();
        
    }
}
*/

package com.apex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}