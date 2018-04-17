package org.echocat.kata.java.part1.authors;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="email")
public class Author {
    private String email;
    private String firstname;
    private String lastname;
}
