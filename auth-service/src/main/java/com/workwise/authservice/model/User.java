package com.workwise.authservice.model;

public class User {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String image;
    private Role role;

    public User(String id, String email, String firstName, String lastName, Role role, String image) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role= role;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getEmail() { return email; }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getRole() {
        return role.toString();
    }

    public String getImage() {
        return this.image;
    }
}
