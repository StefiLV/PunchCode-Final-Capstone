package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class RegisterUserDTO {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;
    @NotEmpty(message = "Please select a role for this user.")
    private String role;
    private boolean organization;
    private String address;
    private String birthDate;
    private String name;

    public String getName(){ return name; }
    public void setName(String name){this.name = name;}

    public String getAddress(){ return address; }
    public void setAddress(String address){ this.address = address; }

    public String getBirthDate() {return birthDate;}
    public void setBirthDate(String birthDate){ this.birthDate = birthDate; }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isOrganization() {
        return organization;
    }

    public void setOrganization(boolean organization) {
        this.organization = organization;
    }
}

