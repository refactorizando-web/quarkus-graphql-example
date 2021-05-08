package com.refactorizando.samples.graphql.quarkus.repository;

import com.refactorizando.samples.graphql.quarkus.domain.Bank;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BankRepository implements PanacheRepository<Bank> {

}
