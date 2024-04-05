package com.workwise.userservice.model;

public class Candidate {
    private final UserData userData;
    private final String id;
    private String experience;
    private String skills;
    private String description;
    private boolean searchable;

    public Candidate(UserData UserData, String id, String experience, String skills, String description, boolean searchable) {
        this.userData = UserData;
        this.id = id;
        this.experience = experience;
        this.skills = skills;
        this.description = description;
        this.searchable = searchable;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public String getId() {
        return this.id;
    }

    public String getExperience() {
        return this.experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkills() {
        return this.skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSearchable() {
        return this.searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }
}
