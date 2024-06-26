package com.acme.sporteaseplatform.iam.domain.model.queries;

import com.acme.sporteaseplatform.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
