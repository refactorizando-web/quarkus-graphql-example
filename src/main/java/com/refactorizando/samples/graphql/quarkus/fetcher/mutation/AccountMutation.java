package com.refactorizando.samples.graphql.quarkus.fetcher.mutation;

import com.refactorizando.samples.graphql.quarkus.domain.Account;
import com.refactorizando.samples.graphql.quarkus.domain.Bank;
import com.refactorizando.samples.graphql.quarkus.domain.User;
import com.refactorizando.samples.graphql.quarkus.domain.input.AccountInput;
import com.refactorizando.samples.graphql.quarkus.repository.AccountRepository;
import com.refactorizando.samples.graphql.quarkus.repository.BankRepository;
import com.refactorizando.samples.graphql.quarkus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

import javax.transaction.Transactional;

@GraphQLApi
@RequiredArgsConstructor
public class AccountMutation {

    private final AccountRepository accountRepository;

    private final BankRepository bankRepository;

    private final UserRepository userRepository;

    @Mutation("createAccount")
    @Transactional
    public Account createAccount(@Name("account") AccountInput account) {
        User user = userRepository.findById(account.getUserId());
        Bank bank = bankRepository.findById(account.getBankId());

        var accountToSave = new Account(null,
                account.getName(), account.getAlias(), account.getAmount(), user, bank);
        accountRepository.persistAndFlush(accountToSave);
        return accountToSave;
    }
}