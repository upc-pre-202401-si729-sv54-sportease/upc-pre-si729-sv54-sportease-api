package com.acme.sporteaseplatform.iam.domain.model.commands;

import com.acme.sporteaseplatform.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
