package com.apex.index;

import com.apex.model.Profile;
import java.util.NavigableMap;
import java.util.TreeMap;

public class ProfileIndex {

    // Key: timestamp, Value: profileId
    private final NavigableMap<Long, Integer> index = new TreeMap<>();

    public synchronized void add(Profile profile) {
        index.put(profile.getCreatedAt(), profile.getId());
    }

    public synchronized Integer getOldestProfileId() {
        if (index.isEmpty()) return null;
        return index.firstEntry().getValue();
    }

    public synchronized Integer getNewestProfileId() {
        if (index.isEmpty()) return null;
        return index.lastEntry().getValue();
    }

    public synchronized int size() {
        return index.size();
    }
}
