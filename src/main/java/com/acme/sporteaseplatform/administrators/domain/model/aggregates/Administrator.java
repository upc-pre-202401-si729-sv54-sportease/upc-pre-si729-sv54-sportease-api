package com.acme.sporteaseplatform.administrators.domain.model.aggregates;

import com.acme.sporteaseplatform.administrators.domain.model.commands.CreateAdministratorCommand;
import com.acme.sporteaseplatform.shared.domain.model.aggregates.PersonAbstractAggregateRoot;

public class Administrator extends PersonAbstractAggregateRoot<Administrator> {

    protected Administrator(){}

    public Administrator(CreateAdministratorCommand command){
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.email = command.email();
        this.password = command.password();
        this.userType = command.userType();
    }
}
