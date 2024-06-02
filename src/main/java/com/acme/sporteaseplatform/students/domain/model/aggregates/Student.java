package com.acme.sporteaseplatform.students.domain.model.aggregates;

import com.acme.sporteaseplatform.shared.domain.model.aggregates.PersonAbstractAggregateRoot;
import com.acme.sporteaseplatform.students.domain.model.commands.CreateStudentCommand;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Student extends PersonAbstractAggregateRoot<Student> {

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private Integer category;

    @Column(nullable = false)
    private LocalDate paymentDueDate;

    public Student(CreateStudentCommand command){
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.email = command.email();
        this.password = command.password();
        this.userType = command.userType();
        this.category = command.category();
        this.birthDate = command.birthDate();
        this.paymentDueDate = command.paymentDueDate();
    }

    public Student() {}
}
