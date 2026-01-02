package com.apex.controller;

import com.apex.model.Profile;
import com.apex.processor.ProfileProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileProcessor processor;

    public ProfileController(ProfileProcessor processor) {
        this.processor = processor;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable int id) {

        Profile profile = processor.process(id);

        if (profile == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(profile);
    }
}
