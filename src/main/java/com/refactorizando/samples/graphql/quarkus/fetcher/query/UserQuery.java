package com.refactorizando.samples.graphql.quarkus.fetcher.query;

import com.refactorizando.samples.graphql.quarkus.domain.User;
import com.refactorizando.samples.graphql.quarkus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
@RequiredArgsConstructor
public class UserQuery {

    private final UserRepository userRepository;


    @Query("users")
    public List<User> findAll() {

        return (List<User>) userRepository.findAll();

    }

    @Query("user")
    public User findById(@Name("id") Long id) {

            return userRepository.findById(id);

    }
}
