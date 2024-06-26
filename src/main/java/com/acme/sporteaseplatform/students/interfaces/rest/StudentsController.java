package com.acme.sporteaseplatform.students.interfaces.rest;


import com.acme.sporteaseplatform.students.domain.model.queries.*;
import com.acme.sporteaseplatform.students.domain.services.StudentCommandService;
import com.acme.sporteaseplatform.students.domain.services.StudentQueryService;
import com.acme.sporteaseplatform.students.interfaces.rest.resources.CreateStudentResource;
import com.acme.sporteaseplatform.students.interfaces.rest.resources.StudentResource;
import com.acme.sporteaseplatform.students.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import com.acme.sporteaseplatform.students.interfaces.rest.transform.StudentResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentsController {
    private final StudentQueryService studentQueryService;
    private final StudentCommandService studentCommandService;

    public StudentsController(StudentQueryService studentQueryService, StudentCommandService studentCommandService) {
        this.studentQueryService = studentQueryService;
        this.studentCommandService = studentCommandService;
    }

    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource) {
        var createProfileCommand = CreateStudentCommandFromResourceAssembler.toCommandFromResource(resource);
        var student = studentCommandService.handle(createProfileCommand);
        if (student.isEmpty()) return ResponseEntity.badRequest().build();
        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);
    }

    @GetMapping("/identifier/{Id}")
    public ResponseEntity<StudentResource> getStudentById(@PathVariable Long Id) {
        var getStudentByIdQuery = new GetStudentByIdQuery(Id);
        var student = studentQueryService.handle(getStudentByIdQuery);
        if (student.isEmpty()) return  ResponseEntity.badRequest().build();
        var profileResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return ResponseEntity.ok(profileResource);
    }

    @GetMapping("/{studentCategory}")
    public ResponseEntity<List<StudentResource>> getStudentByCategory(@PathVariable Integer studentCategory) {
        var getAllStudentByCategoryQuery = new GetAllStudentsByCategoryQuery(studentCategory);
        var student = studentQueryService.handle(getAllStudentByCategoryQuery);
        if (student.isEmpty()) return ResponseEntity.notFound().build();
        var studentResources = student.stream().map(
                StudentResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(studentResources);
    }

    @GetMapping("/birthday-today")
    public ResponseEntity<List<StudentResource>> getStudentByBirthDate() {
        var getAllStudentByBirthDateQuery = new GetAllStudentsWithBirthdayTodayQuery();
        var student = studentQueryService.handle(getAllStudentByBirthDateQuery);
        if (student.isEmpty()) return ResponseEntity.notFound().build();
        var studentResources = student.stream().map(
                StudentResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(studentResources);
    }

    @GetMapping("/due-payment-today")
    public ResponseEntity<List<StudentResource>> getStudentByPaymentDueDateBefore() {
        var getAllStudentByPaymentDueDateQuery = new GetAllStudentsWithDuePaymentQuery();
        var student = studentQueryService.handle(getAllStudentByPaymentDueDateQuery);
        if (student.isEmpty()) return ResponseEntity.notFound().build();
        var studentResources = student.stream().map(
                StudentResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(studentResources);
    }

    @GetMapping
    public ResponseEntity<List<StudentResource>> getAllStudent() {
        var getAllStudentQuery = new GetAllStudentsQuery();
        var student = studentQueryService.handle(getAllStudentQuery);
        if (student.isEmpty()) return ResponseEntity.notFound().build();
        var studentResources = student.stream().map(
                StudentResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(studentResources);
    }
}
