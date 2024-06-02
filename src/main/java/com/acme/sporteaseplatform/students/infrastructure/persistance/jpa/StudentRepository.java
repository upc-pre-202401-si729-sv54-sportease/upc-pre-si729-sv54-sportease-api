package com.acme.sporteaseplatform.students.infrastructure.persistance.jpa;

import com.acme.sporteaseplatform.students.domain.model.aggregates.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByCategory(Integer category);
    List<Student> findAllByBirthDate(LocalDate birthDate);
    List<Student> findAllByPaymentDueDateBefore(LocalDate paymentDate);
    Optional<Student> findByEmail(String email);
}
