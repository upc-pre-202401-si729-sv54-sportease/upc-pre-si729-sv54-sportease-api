package com.acme.sporteaseplatform.administrators.domain.model.commands;

public record CreateAdministratorCommand(String firstName, String lastName, String email, String password, String userType) {
    public CreateAdministratorCommand {
        if(firstName == null || firstName.isBlank()){
            throw new IllegalArgumentException("firstName cannot be null or empty");
        }
        if(lastName == null || lastName.isBlank()){
            throw new IllegalArgumentException("lastName cannot be null or empty");
        }
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("email cannot be null or empty");
        }
        if(password == null || password.isBlank()){
            throw new IllegalArgumentException("password cannot be null or empty");
        }
        if(userType == null || userType.isBlank()){
            throw new IllegalArgumentException("userType cannot be null or empty");
        }
    }
}
