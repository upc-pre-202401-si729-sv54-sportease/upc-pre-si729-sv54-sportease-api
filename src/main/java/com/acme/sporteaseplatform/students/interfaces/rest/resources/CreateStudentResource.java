package com.acme.sporteaseplatform.students.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateStudentResource(String firstName, String lastName, String email, String password, String userType, Integer category, LocalDate birthDate, LocalDate paymentDueDate) {
}
