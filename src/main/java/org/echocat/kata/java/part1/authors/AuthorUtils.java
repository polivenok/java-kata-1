package org.echocat.kata.java.part1.authors;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AuthorUtils {

    public static List<Author> filterAuthorsByEmail(List<Author> authors, List<String> authorEmails) {
        Objects.requireNonNull(authorEmails);
        return authors.stream().filter(author -> authorEmails.contains(author.getEmail())).collect(Collectors.toList());
    }
}
