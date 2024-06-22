package com.acme.sporteaseplatform.administrators.interfaces;

import com.acme.sporteaseplatform.administrators.domain.model.queries.GetAdministratorByEmailQuery;
import com.acme.sporteaseplatform.administrators.domain.model.queries.GetAdministratorByIdQuery;
import com.acme.sporteaseplatform.administrators.domain.model.queries.GetAllAdministratorsQuery;
import com.acme.sporteaseplatform.administrators.domain.services.AdministratorCommandService;
import com.acme.sporteaseplatform.administrators.domain.services.AdministratorQueryService;
import com.acme.sporteaseplatform.administrators.interfaces.resources.AdministratorResource;
import com.acme.sporteaseplatform.administrators.interfaces.resources.CreateAdministratorResource;
import com.acme.sporteaseplatform.administrators.interfaces.transform.AdministratorResourceFromEntityAssembler;
import com.acme.sporteaseplatform.administrators.interfaces.transform.CreateAdministratorCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/administrators", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdministratorController {
    private final AdministratorQueryService administratorQueryService;
    private final AdministratorCommandService administratorCommandService;

    public AdministratorController(AdministratorQueryService administratorQueryService, AdministratorCommandService administratorCommandService) {
        this.administratorQueryService = administratorQueryService;
        this.administratorCommandService = administratorCommandService;
    }

    @PostMapping
    public ResponseEntity<AdministratorResource> createAdministrator(@RequestBody CreateAdministratorResource resource) {
        var createAdministratorCommand = CreateAdministratorCommandFromResourceAssembler.toCommandFromResource(resource);
        var administrator = administratorCommandService.handle(createAdministratorCommand);
        if (administrator.isEmpty()) return ResponseEntity.badRequest().build();
        var administratorResource = AdministratorResourceFromEntityAssembler.toResourceFromEntity(administrator.get());
        return new ResponseEntity<>(administratorResource, HttpStatus.CREATED);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<AdministratorResource> getAdministratorById(@PathVariable Long Id) {
        var getAdministratorByIdQuery = new GetAdministratorByIdQuery(Id);
        var administrator = administratorQueryService.handle(getAdministratorByIdQuery);
        if (administrator.isEmpty()) return  ResponseEntity.badRequest().build();
        var profileResource = AdministratorResourceFromEntityAssembler.toResourceFromEntity(administrator.get());
        return ResponseEntity.ok(profileResource);
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<AdministratorResource>> getAdministratorByEmail(@PathVariable String email) {
        var getAdministratorByEmailQuery = new GetAdministratorByEmailQuery(email);
        var administrator = administratorQueryService.handle(getAdministratorByEmailQuery);
        if (administrator.isEmpty()) return ResponseEntity.notFound().build();
        var administratorResources = administrator.stream().map(
                AdministratorResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(administratorResources);
    }

    @GetMapping
    public ResponseEntity<List<AdministratorResource>> getAllAdministrators() {
        var getAllAdministratorsQuery = new GetAllAdministratorsQuery();
        var administrators = administratorQueryService.handle(getAllAdministratorsQuery);
        var administratorsResources = administrators.stream().map(
                AdministratorResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(administratorsResources);
    }
}
