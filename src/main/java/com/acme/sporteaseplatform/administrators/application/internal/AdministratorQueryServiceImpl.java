package com.acme.sporteaseplatform.administrators.application.internal;

import com.acme.sporteaseplatform.administrators.domain.model.aggregates.Administrator;
import com.acme.sporteaseplatform.administrators.domain.model.queries.GetAdministratorByEmailQuery;
import com.acme.sporteaseplatform.administrators.domain.model.queries.GetAdministratorByIdQuery;
import com.acme.sporteaseplatform.administrators.domain.model.queries.GetAllAdministratorsQuery;
import com.acme.sporteaseplatform.administrators.domain.services.AdministratorQueryService;
import com.acme.sporteaseplatform.administrators.infraestructure.persistence.jpa.repositories.AdministratorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorQueryServiceImpl implements AdministratorQueryService {
    private final AdministratorRepository administratorRepository;

    public AdministratorQueryServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public Optional<Administrator> handle(GetAdministratorByIdQuery query) {
        return administratorRepository.findById(query.Id());
    }

    @Override
    public Optional<Administrator> handle(GetAdministratorByEmailQuery query) {
        return administratorRepository.findByEmail(query.email());
    }

    @Override
    public List<Administrator> handle(GetAllAdministratorsQuery query) {
        return administratorRepository.findAll();
    }
}
