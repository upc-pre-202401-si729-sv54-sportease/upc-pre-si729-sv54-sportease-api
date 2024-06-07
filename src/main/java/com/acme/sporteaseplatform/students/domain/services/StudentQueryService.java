package com.acme.sporteaseplatform.students.domain.services;

import com.acme.sporteaseplatform.students.domain.model.aggregates.Student;
import com.acme.sporteaseplatform.students.domain.model.queries.GetAllStudentsByCategoryQuery;
import com.acme.sporteaseplatform.students.domain.model.queries.GetAllStudentsQuery;
import com.acme.sporteaseplatform.students.domain.model.queries.GetAllStudentsWithBirthdayTodayQuery;
import com.acme.sporteaseplatform.students.domain.model.queries.GetAllStudentsWithDuePaymentQuery;

import java.util.List;

public interface StudentQueryService {
    List<Student> handle(GetAllStudentsByCategoryQuery query);
    List<Student> handle(GetAllStudentsQuery query);
    List<Student> handle(GetAllStudentsWithBirthdayTodayQuery query);
    List<Student> handle(GetAllStudentsWithDuePaymentQuery query);
}
