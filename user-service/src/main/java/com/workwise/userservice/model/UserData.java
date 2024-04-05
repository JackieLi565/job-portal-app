package com.workwise.userservice.model;

import java.util.Optional;

public class UserData {
    private final String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String image;
    private final Role role;

    public UserData(Role role, String id, String email, String firstName, String lastName, String image) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }

    public UserData(Role role, String id, String email, String password, String firstName, String lastName, String image) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<String> getPassword() {
        if (this.role == Role.EMAIL_PASSWORD) {
            return Optional.of(this.password);
        }

        return Optional.empty();
    }

    public void setPassword(String password) {
        if (this.role == Role.EMAIL_PASSWORD) {
            this.password = password;
        }
    }

    public Role getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
