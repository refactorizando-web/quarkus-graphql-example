package com.refactorizando.samples.graphql.quarkus.fetcher.mutation;


import com.refactorizando.samples.graphql.quarkus.domain.User;
import com.refactorizando.samples.graphql.quarkus.domain.input.UserInput;
import com.refactorizando.samples.graphql.quarkus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

import javax.transaction.Transactional;

@GraphQLApi

@RequiredArgsConstructor
public class UserMutation {

    private final UserRepository userRepository;

    @Mutation("createUser")
    @Transactional
    public User createUser(@Name("user") UserInput user) {

        var userToSave = new User(null, user.getFirstName(), user.getLastName(), user.getAge(), user.getAddress(), user.getCountry(), user.getCity(), null, null);
        userRepository.persistAndFlush(userToSave);
        return userToSave;
    }

}
