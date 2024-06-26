package com.acme.sporteaseplatform.administrators.domain.services;

import com.acme.sporteaseplatform.administrators.domain.model.aggregates.Administrator;
import com.acme.sporteaseplatform.administrators.domain.model.commands.CreateAdministratorCommand;
import com.acme.sporteaseplatform.administrators.domain.model.commands.DeleteAdministratorCommand;

import java.util.Optional;

public interface AdministratorCommandService {
    Optional<Administrator> handle(CreateAdministratorCommand command);
    void handle(DeleteAdministratorCommand command);
}
