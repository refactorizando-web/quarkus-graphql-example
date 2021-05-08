package com.refactorizando.samples.graphql.quarkus.fetcher.mutation;

import com.refactorizando.samples.graphql.quarkus.domain.Bank;
import com.refactorizando.samples.graphql.quarkus.domain.input.BankInput;
import com.refactorizando.samples.graphql.quarkus.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

import javax.transaction.Transactional;


@GraphQLApi

@RequiredArgsConstructor
public class BankMutation {

    private final BankRepository repository;

    @Mutation("createBank")
    @Transactional
    public Bank createBank(@Name("bank") BankInput bank) {

        var bankToSave = new Bank(null, bank.getName(), bank.getCountry(), null, null);
        repository.persist(bankToSave);

        return bankToSave;
    }

}
