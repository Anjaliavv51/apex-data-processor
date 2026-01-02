package com.apex.config;

import com.apex.cache.LRUCache;
import com.apex.concurrency.TaskExecutor;
import com.apex.model.Profile;
import com.apex.processor.ProfileProcessor;
import com.apex.repository.ProfileRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public LRUCache<Integer, Profile> lruCache() {
        return new LRUCache<>(100);
    }

    @Bean(name = "apexTaskExecutor")
public TaskExecutor apexTaskExecutor() {
    int poolSize = Runtime.getRuntime().availableProcessors();
    return new TaskExecutor(poolSize);
}


    @Bean
    public ProfileProcessor profileProcessor(
            ProfileRepository repository,
            LRUCache<Integer, Profile> cache) {

        return new ProfileProcessor(repository, cache);
    }
}
