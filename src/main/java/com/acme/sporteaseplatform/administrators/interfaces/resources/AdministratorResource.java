package com.acme.sporteaseplatform.administrators.interfaces.resources;

public record AdministratorResource(Long id, String firstName, String lastName, String email, String password, String userType) {
}
