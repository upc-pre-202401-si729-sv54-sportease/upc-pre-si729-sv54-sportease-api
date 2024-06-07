package com.acme.sporteaseplatform.students.domain.model.commands;

import java.time.LocalDate;

public record CreateStudentCommand(String firstName, String lastName, String email, String password, String userType, Integer category, LocalDate birthDate, LocalDate paymentDueDate) {
    public CreateStudentCommand{
        if (firstName == null || firstName.isBlank()){
            throw new IllegalArgumentException("firstName cannot be null or empty");
        }
        if (lastName == null || lastName.isBlank()){
            throw new IllegalArgumentException("lastName cannot be null or empty");
        }
        if (email == null || email.isBlank()){
            throw new IllegalArgumentException("email cannot be null or empty");
        }
        if (password == null || password.isBlank()){
            throw new IllegalArgumentException("password cannot be null or empty");
        }
        if (userType == null || userType.isBlank()){
            throw new IllegalArgumentException("type cannot be null or empty");
        }
        if (category == null){
            throw new IllegalArgumentException("category cannot be null");
        }
        if (birthDate == null){
            throw new IllegalArgumentException("birthDate cannot be null");
        }
    }

}
