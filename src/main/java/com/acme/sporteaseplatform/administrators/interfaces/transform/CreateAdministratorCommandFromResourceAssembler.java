package com.acme.sporteaseplatform.administrators.interfaces.transform;

import com.acme.sporteaseplatform.administrators.domain.model.commands.CreateAdministratorCommand;
import com.acme.sporteaseplatform.administrators.interfaces.resources.CreateAdministratorResource;

public class CreateAdministratorCommandFromResourceAssembler {
    public static CreateAdministratorCommand toCommandFromResource(CreateAdministratorResource resource) {
        return new CreateAdministratorCommand(resource.firstName(), resource.lastName(), resource.email(), resource.password(),
                resource.userType());
    }
}
