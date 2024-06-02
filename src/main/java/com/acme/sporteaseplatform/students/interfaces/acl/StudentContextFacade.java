package com.acme.sporteaseplatform.students.interfaces.acl;

import com.acme.sporteaseplatform.students.domain.model.aggregates.Student;
import com.acme.sporteaseplatform.students.domain.model.commands.CreateStudentByAdminCommand;
import com.acme.sporteaseplatform.students.domain.model.queries.GetAllStudentsByCategoryQuery;
import com.acme.sporteaseplatform.students.domain.model.queries.GetAllStudentsWithBirthdayTodayQuery;
import com.acme.sporteaseplatform.students.domain.model.queries.GetAllStudentsWithDuePaymentQuery;
import com.acme.sporteaseplatform.students.domain.services.StudentCommandService;
import com.acme.sporteaseplatform.students.domain.services.StudentQueryService;


import java.time.LocalDate;
import java.util.List;

public class StudentContextFacade {
    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;

    public StudentContextFacade(StudentCommandService studentCommandService, StudentQueryService studentQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
    }

    public Long createStudentByAdmin(String name, String lastName, Integer category, LocalDate birthDate, LocalDate paymentDueDate) {
        var createStudentCommand = new CreateStudentByAdminCommand(name, lastName, category, birthDate, paymentDueDate);
        var student = studentCommandService.handle(createStudentCommand);
        if (student.isEmpty()) return 0L;
        return student.get().getId();
    }

    public List<Student> getStudentsByCategory(Integer category) {
        var getAllStudentsByCategoryQuery = new GetAllStudentsByCategoryQuery(category);
        return studentQueryService.handle(getAllStudentsByCategoryQuery);
    }

    public List<Student> getStudentsByBirthDate() {
        var getStudentsByBirthDateQuery = new GetAllStudentsWithBirthdayTodayQuery();
        return studentQueryService.handle(getStudentsByBirthDateQuery);
    }

    public List<Student> getStudentsByPaymentDueDate() {
        var getStudentsByPaymentDueDateQuery = new GetAllStudentsWithDuePaymentQuery();
        return studentQueryService.handle(getStudentsByPaymentDueDateQuery);
    }
}
