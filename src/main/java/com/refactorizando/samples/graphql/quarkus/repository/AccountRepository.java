package com.refactorizando.samples.graphql.quarkus.repository;

import com.refactorizando.samples.graphql.quarkus.domain.Account;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountRepository implements PanacheRepository<Account> {
}
