package com.acme.sporteaseplatform.administrators.interfaces.transform;

import com.acme.sporteaseplatform.administrators.domain.model.aggregates.Administrator;
import com.acme.sporteaseplatform.administrators.interfaces.resources.AdministratorResource;

public class AdministratorResourceFromEntityAssembler {
    public static AdministratorResource toResourceFromEntity(Administrator entity) {
        return new AdministratorResource(entity.getId(), entity.getFirstName(), entity.getLastName(),
                entity.getEmail(), entity.getPassword(), entity.getUserType());
    }
}
