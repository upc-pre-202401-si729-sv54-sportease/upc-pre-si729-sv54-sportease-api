package com.acme.sporteaseplatform.students.domain.services;

import com.acme.sporteaseplatform.students.domain.model.aggregates.Student;
import com.acme.sporteaseplatform.students.domain.model.commands.CreateStudentByAdminCommand;
import com.acme.sporteaseplatform.students.domain.model.commands.CreateStudentCommand;
import com.acme.sporteaseplatform.students.domain.model.commands.DeleteStudentCommand;

import java.util.Optional;

public interface StudentCommandService {
    Optional<Student> handle(CreateStudentCommand command);
    Optional<Student> handle(CreateStudentByAdminCommand command);
    void handle(DeleteStudentCommand command);
}
