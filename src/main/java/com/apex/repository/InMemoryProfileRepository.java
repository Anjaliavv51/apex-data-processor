/* 
package com.apex.repository;

import com.apex.model.Profile;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryProfileRepository implements ProfileRepository {

    private final ConcurrentHashMap<Integer, Profile> store = new ConcurrentHashMap<>();

    @Override
    public void save(Profile profile) {
        store.put(profile.getId(), profile);
    }

    @Override
    public Profile findById(int id) {
        return store.get(id);
    }
}
*/

package com.apex.repository;

import com.apex.model.Profile;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryProfileRepository implements ProfileRepository {

    private final ConcurrentHashMap<Integer, Profile> store = new ConcurrentHashMap<>();

    @Override
    public void save(Profile profile) {
        store.put(profile.getId(), profile);
    }

    @Override
    public Profile findById(int id) {
        return store.get(id);
    }
}
