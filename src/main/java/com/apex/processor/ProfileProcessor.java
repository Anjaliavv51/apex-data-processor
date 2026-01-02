package com.apex.processor;

import com.apex.cache.LRUCache;
import com.apex.model.Profile;
import com.apex.repository.ProfileRepository;

public class ProfileProcessor {

    private final ProfileRepository repository;
    private final LRUCache<Integer, Profile> cache;

    public ProfileProcessor(ProfileRepository repository,
                            LRUCache<Integer, Profile> cache) {
        this.repository = repository;
        this.cache = cache;
    }

    public Profile process(int profileId) {

        // 1️⃣ Try cache first
        Profile profile = cache.get(profileId);
        if (profile != null) {
            return profile;
        }

        // 2️⃣ Fallback to repository
        profile = repository.findById(profileId);

        // 3️⃣ Populate cache for future access
        if (profile != null) {
            cache.put(profileId, profile);
        }

        return profile;
    }
}
