package com.acme.sporteaseplatform.students.interfaces.rest.resources;

import java.time.LocalDate;

public record StudentResource(Long id, String firstName, String lastName, String email, String password, String usertype, Integer category, LocalDate birthDate, LocalDate paymentDueDate) {


}
