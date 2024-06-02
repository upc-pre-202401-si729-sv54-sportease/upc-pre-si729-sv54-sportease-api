package com.acme.sporteaseplatform.students.interfaces.rest.transform;

import com.acme.sporteaseplatform.students.domain.model.aggregates.Student;
import com.acme.sporteaseplatform.students.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(Student entity) {
        return new StudentResource(entity.getId(), entity.getFirstName(), entity.getLastName(),
                entity.getEmail(), entity.getPassword(), entity.getUserType(), entity.getCategory(), entity.getBirthDate(), entity.getPaymentDueDate());
    }
}
