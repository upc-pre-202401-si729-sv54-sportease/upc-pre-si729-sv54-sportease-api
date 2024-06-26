package com.acme.sporteaseplatform.iam.domain.services;

import com.acme.sporteaseplatform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
    
}
