package com.acme.sporteaseplatform.administrators.infraestructure.persistence.jpa.repositories;

import com.acme.sporteaseplatform.administrators.domain.model.aggregates.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorRepository  extends JpaRepository<Administrator, Long> {
    Optional<Administrator> findByEmail(String emailAddress);
}
