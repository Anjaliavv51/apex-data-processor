package com.apex.repository;

import com.apex.model.Profile;

public interface ProfileRepository {

    void save(Profile profile);

    Profile findById(int id);
}
