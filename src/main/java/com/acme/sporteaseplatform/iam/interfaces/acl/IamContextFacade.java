package com.acme.sporteaseplatform.iam.interfaces.acl;

import com.acme.sporteaseplatform.iam.domain.model.commands.SignUpCommand;
import com.acme.sporteaseplatform.iam.domain.model.entities.Role;
import com.acme.sporteaseplatform.iam.domain.model.queries.GetUserByIdQuery;
import com.acme.sporteaseplatform.iam.domain.model.queries.GetUserByUsernameQuery;
import com.acme.sporteaseplatform.iam.domain.services.UserCommandService;
import com.acme.sporteaseplatform.iam.domain.services.UserQueryService;
import io.jsonwebtoken.lang.Strings;

import java.util.ArrayList;
import java.util.List;

public class IamContextFacade {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public IamContextFacade(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    public Long createUser(String userName, String password) {
        var signUpCommand = new SignUpCommand(userName, password, List.of(Role.getDefaultRole()));
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return  0L;
        return result.get().getId();
    }

    public Long createUser(String userName, String password, List<String> roleNames) {
        var roles = roleNames != null ? roleNames.stream().map(Role::toRoleFromName).toList() : new ArrayList<Role>();
        var signUpCommand = new SignUpCommand(userName, password, roles);
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return  0L;
        return result.get().getId();
    }

    public Long fetchUserIdByUsername(String userName) {
        var getUserByUsernameQuery = new GetUserByUsernameQuery(userName);
        var result = userQueryService.handle(getUserByUsernameQuery);
        if (result.isEmpty()) return  0L;
        return result.get().getId();
    }

    public String fetchUserUsernameById(Long userId) {
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var result = userQueryService.handle(getUserByIdQuery);
        if (result.isEmpty()) return Strings.EMPTY;
        return result.get().getUsername();
    }
}
