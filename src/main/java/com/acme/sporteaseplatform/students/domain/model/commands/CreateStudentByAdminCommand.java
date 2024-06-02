package com.acme.sporteaseplatform.students.domain.model.commands;

import java.time.LocalDate;

public record CreateStudentByAdminCommand(String firstName, String lastName, Integer category, LocalDate birthDate, LocalDate paymentDueDate) {
    public CreateStudentByAdminCommand{
        if (firstName == null || firstName.isBlank()){
            throw new IllegalArgumentException("firstName cannot be null or empty");
        }
        if (lastName == null || lastName.isBlank()){
            throw new IllegalArgumentException("lastName cannot be null or empty");
        }
        if (category == null){
            throw new IllegalArgumentException("category cannot be null");
        }
        if (birthDate == null){
            throw new IllegalArgumentException("birthDate cannot be null");
        }
    }
}