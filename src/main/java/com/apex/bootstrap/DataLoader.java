package com.apex.bootstrap;

import com.apex.model.Profile;
import com.apex.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProfileRepository repository;

    public DataLoader(ProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        for (int i = 1; i <= 500; i++) {
            repository.save(new Profile(i, "User-" + i));
        }
        System.out.println("✅ Preloaded 500 profiles");
    }
}
