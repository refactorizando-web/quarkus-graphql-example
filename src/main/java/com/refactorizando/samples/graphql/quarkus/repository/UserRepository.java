package com.refactorizando.samples.graphql.quarkus.repository;

import com.refactorizando.samples.graphql.quarkus.domain.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
