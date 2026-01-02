package com.apex.model;

public class Profile {

    private final int id;
    private final String name;
    private final long createdAt;

    public Profile(int id, String name) {
        this.id = id;
        this.name = name;
        this.createdAt = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
