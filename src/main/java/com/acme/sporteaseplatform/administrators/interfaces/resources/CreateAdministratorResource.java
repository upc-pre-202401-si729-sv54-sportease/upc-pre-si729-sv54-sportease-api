package com.acme.sporteaseplatform.administrators.interfaces.resources;

public record CreateAdministratorResource(String firstName, String lastName, String email, String password, String userType) {
}
