package com.refactorizando.samples.graphql.quarkus.domain.input;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BankInput {

    private String name;

    private String country;
}
