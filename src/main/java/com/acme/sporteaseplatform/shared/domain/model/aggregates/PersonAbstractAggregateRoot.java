package com.acme.sporteaseplatform.shared.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class PersonAbstractAggregateRoot<T extends AbstractAggregateRoot<T>> extends AbstractAggregateRoot<T>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Setter
    protected String firstName;

    @Column(nullable = false)
    @Setter
    protected String lastName;

    @Column(nullable = false)
    @Setter
    protected String email;

    @Column(nullable = false)
    @Setter
    protected String password;

    @Column(nullable = false)
    @Setter
    protected String userType;

    public String getFullName(){
        return String.format("%s %s", firstName, lastName);
    }
}
