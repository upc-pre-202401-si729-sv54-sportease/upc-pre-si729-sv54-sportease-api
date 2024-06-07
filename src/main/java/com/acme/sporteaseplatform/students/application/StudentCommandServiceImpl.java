package com.acme.sporteaseplatform.students.application;

import com.acme.sporteaseplatform.students.domain.model.aggregates.Student;
import com.acme.sporteaseplatform.students.domain.model.commands.CreateStudentByAdminCommand;
import com.acme.sporteaseplatform.students.domain.model.commands.CreateStudentCommand;
import com.acme.sporteaseplatform.students.domain.services.StudentCommandService;
import com.acme.sporteaseplatform.students.infrastructure.persistance.jpa.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentCommandServiceImpl implements StudentCommandService {

    private final StudentRepository studentRepository;

    public StudentCommandServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> handle(CreateStudentCommand command) {
        studentRepository.findByEmail(command.email()).ifPresent(student -> {
            throw new IllegalArgumentException("An student with Email" + command.email() + "already exists");
        });
        var student = new Student(command);
        studentRepository.save(student);
        return Optional.of(student);
    }

    @Override
    public Optional<Student> handle(CreateStudentByAdminCommand command) {
        return Optional.empty();
    }
}
