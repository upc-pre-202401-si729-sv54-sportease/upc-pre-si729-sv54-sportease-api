package com.acme.sporteaseplatform.students.interfaces.rest.transform;


import com.acme.sporteaseplatform.students.domain.model.commands.CreateStudentCommand;
import com.acme.sporteaseplatform.students.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentCommandFromResourceAssembler {
    public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource) {
        return new CreateStudentCommand(resource.firstName(), resource.lastName(), resource.email(), resource.password(),
                resource.userType(), resource.category(), resource.birthDate(), resource.paymentDueDate());
    }
}
