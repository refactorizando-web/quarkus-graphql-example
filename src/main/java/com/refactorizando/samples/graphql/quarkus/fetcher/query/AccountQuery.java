package com.refactorizando.samples.graphql.quarkus.fetcher.query;

import com.refactorizando.samples.graphql.quarkus.domain.Account;
import com.refactorizando.samples.graphql.quarkus.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;
import java.util.stream.Collectors;

@GraphQLApi
@RequiredArgsConstructor
public class AccountQuery {

    private final AccountRepository repository;

    @Query("accounts")
    public List<Account> findAll() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    @Query("account")
    public Account findById(@Name("id") Long id) {
        return repository.findById(id);
    }
}