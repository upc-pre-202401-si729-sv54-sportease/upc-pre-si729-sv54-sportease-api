package com.acme.sporteaseplatform.iam.interfaces.rest.transform;

import com.acme.sporteaseplatform.iam.domain.model.entities.Role;
import com.acme.sporteaseplatform.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role){
        return new RoleResource(role.getId(), role.getStringName());
    }
}
