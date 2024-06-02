package com.acme.sporteaseplatform.students.domain.model.queries;

import java.time.LocalDate;

public record GetAllStudentsWithDuePaymentQuery() {
    public LocalDate currentDate() {
        return LocalDate.now();
    }
}