package com.acme.sporteaseplatform.administrators.application.internal;

import com.acme.sporteaseplatform.administrators.domain.model.aggregates.Administrator;
import com.acme.sporteaseplatform.administrators.domain.model.commands.CreateAdministratorCommand;
import com.acme.sporteaseplatform.administrators.domain.model.commands.DeleteAdministratorCommand;
import com.acme.sporteaseplatform.administrators.domain.services.AdministratorCommandService;
import com.acme.sporteaseplatform.administrators.infraestructure.persistence.jpa.repositories.AdministratorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministratorCommandServiceImpl implements AdministratorCommandService {
    private final AdministratorRepository administratorRepository;

    public AdministratorCommandServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public Optional<Administrator> handle(CreateAdministratorCommand command) {
        administratorRepository.findByEmail(command.email()).ifPresent(student -> {
            throw new IllegalArgumentException("An student with Email" + command.email() + "already exists");
        });
        var administrator = new Administrator(command);
        administratorRepository.save(administrator);
        return Optional.of(administrator);
    }

    @Override
    public void handle(DeleteAdministratorCommand command) {
        if (!administratorRepository.existsById(command.administratorId())) {
            throw new IllegalArgumentException("Administrator does not exits");
        }
        try {
            administratorRepository.deleteById(command.administratorId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting administrator: "+e.getMessage());
        }
    }
}
