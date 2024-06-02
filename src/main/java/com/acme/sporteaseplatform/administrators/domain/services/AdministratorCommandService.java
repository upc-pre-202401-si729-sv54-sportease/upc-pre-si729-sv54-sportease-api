package com.acme.sporteaseplatform.administrators.domain.services;

import com.acme.sporteaseplatform.administrators.domain.model.aggregates.Administrator;
import com.acme.sporteaseplatform.administrators.domain.model.commands.CreateAdministratorCommand;

import java.util.Optional;

public interface AdministratorCommandService {
    Optional<Administrator> handle(CreateAdministratorCommand command);
}
