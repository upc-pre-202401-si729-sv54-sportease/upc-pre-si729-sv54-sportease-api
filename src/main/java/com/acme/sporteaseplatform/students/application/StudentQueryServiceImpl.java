package com.acme.sporteaseplatform.students.application;

import com.acme.sporteaseplatform.students.domain.model.aggregates.Student;
import com.acme.sporteaseplatform.students.domain.model.queries.GetAllStudentsByCategoryQuery;
import com.acme.sporteaseplatform.students.domain.model.queries.GetAllStudentsQuery;
import com.acme.sporteaseplatform.students.domain.model.queries.GetAllStudentsWithBirthdayTodayQuery;
import com.acme.sporteaseplatform.students.domain.model.queries.GetAllStudentsWithDuePaymentQuery;
import com.acme.sporteaseplatform.students.domain.services.StudentQueryService;
import com.acme.sporteaseplatform.students.infrastructure.persistance.jpa.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentQueryServiceImpl implements StudentQueryService {
    private final StudentRepository studentRepository;

    public StudentQueryServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> handle(GetAllStudentsByCategoryQuery query) {
        return studentRepository.findAllByCategory(query.category());
    }

    @Override
    public List<Student> handle(GetAllStudentsQuery query) {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> handle(GetAllStudentsWithBirthdayTodayQuery query) {
        return studentRepository.findAllByBirthDate(query.currentDate());
    }

    @Override
    public List<Student> handle(GetAllStudentsWithDuePaymentQuery query) {
        return studentRepository.findAllByPaymentDueDateBefore(query.currentDate());
    }
}
