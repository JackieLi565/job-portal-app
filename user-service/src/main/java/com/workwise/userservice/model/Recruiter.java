package com.workwise.userservice.model;

public class Recruiter {
    private final UserData userData;
    private final String id;
    private String company;
    public Recruiter(UserData userData, String id, String company) {
        this.userData = userData;
        this.id = id;
        this.company = company;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public String getId() {
        return this.id;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
