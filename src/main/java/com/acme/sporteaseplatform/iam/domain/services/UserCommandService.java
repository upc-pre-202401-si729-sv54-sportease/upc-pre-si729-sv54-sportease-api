package com.acme.sporteaseplatform.iam.domain.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import com.acme.sporteaseplatform.iam.domain.model.aggregates.User;
import com.acme.sporteaseplatform.iam.domain.model.commands.SignInCommand;
import com.acme.sporteaseplatform.iam.domain.model.commands.SignUpCommand;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(SignUpCommand command);
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
}
