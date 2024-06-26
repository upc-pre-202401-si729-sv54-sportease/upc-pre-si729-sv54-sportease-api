package com.acme.sporteaseplatform.students.domain.services;

import com.acme.sporteaseplatform.students.domain.model.aggregates.Student;
import com.acme.sporteaseplatform.students.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface StudentQueryService {
    List<Student> handle(GetAllStudentsByCategoryQuery query);
    List<Student> handle(GetAllStudentsQuery query);
    List<Student> handle(GetAllStudentsWithBirthdayTodayQuery query);
    List<Student> handle(GetAllStudentsWithDuePaymentQuery query);
    Optional<Student> handle(GetStudentByIdQuery query);
}
