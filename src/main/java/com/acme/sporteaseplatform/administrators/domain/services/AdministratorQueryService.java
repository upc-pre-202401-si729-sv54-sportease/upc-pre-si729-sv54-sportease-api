package com.acme.sporteaseplatform.administrators.domain.services;

import com.acme.sporteaseplatform.administrators.domain.model.aggregates.Administrator;
import com.acme.sporteaseplatform.administrators.domain.model.queries.GetAdministratorByEmailQuery;
import com.acme.sporteaseplatform.administrators.domain.model.queries.GetAdministratorByIdQuery;
import com.acme.sporteaseplatform.administrators.domain.model.queries.GetAllAdministratorsQuery;

import java.util.List;
import java.util.Optional;

public interface AdministratorQueryService {
    Optional<Administrator> handle(GetAdministratorByIdQuery query);

    Optional<Administrator> handle(GetAdministratorByEmailQuery query);

    List<Administrator> handle(GetAllAdministratorsQuery query);
}
