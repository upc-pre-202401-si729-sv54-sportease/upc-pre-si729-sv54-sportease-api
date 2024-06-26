package com.acme.sporteaseplatform.iam.interfaces.rest;

import com.acme.sporteaseplatform.iam.domain.services.UserCommandService;
import com.acme.sporteaseplatform.iam.interfaces.rest.resources.AuthenticatedUserResource;
import com.acme.sporteaseplatform.iam.interfaces.rest.resources.SignInResource;
import com.acme.sporteaseplatform.iam.interfaces.rest.resources.SignUpResource;
import com.acme.sporteaseplatform.iam.interfaces.rest.resources.UserResource;
import com.acme.sporteaseplatform.iam.interfaces.rest.transform.AuthenticatedUserResourceFromEntityAssembler;
import com.acme.sporteaseplatform.iam.interfaces.rest.transform.SignInCommandFromResourceAssembler;
import com.acme.sporteaseplatform.iam.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import com.acme.sporteaseplatform.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {
    private final UserCommandService userCommandService;

    public AuthenticationController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticatedUserResource> signIn(@RequestBody SignInResource resource) {
        var signInCommand = SignInCommandFromResourceAssembler.toCommandFromResource(resource);
        var authenticatedUser = userCommandService.handle(signInCommand);
        if (authenticatedUser.isEmpty()) return ResponseEntity.notFound().build();
        var authenticatedUserResource = AuthenticatedUserResourceFromEntityAssembler.toResourceFromEntity(
                authenticatedUser.get().getLeft(), authenticatedUser.get().getRight()
        );
        return ResponseEntity.ok(authenticatedUserResource);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserResource> signIn(@RequestBody SignUpResource resource) {
        var signUpCommand = SignUpCommandFromResourceAssembler.toCommandFromResource(resource);
        var user = userCommandService.handle(signUpCommand);
        if (user.isEmpty()) return ResponseEntity.notFound().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(
                user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }
}

