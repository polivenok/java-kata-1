package org.echocat.kata.java.part1.library;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class LibraryRepository<T extends LibraryEntry> {

    public abstract List<T> getAll() throws IOException ;

    public Optional<LibraryEntry> findByIsbn(String isbn) throws IOException  {
        Objects.requireNonNull(isbn);
        return getAll().stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .map(e->(LibraryEntry)e)
                .findFirst();
    }

    public List<LibraryEntry> findByEmail(String email) throws IOException {
        Objects.requireNonNull(email);
        return getAll().stream()
                .filter(book -> book.getAuthors() != null && book.getAuthors().stream().anyMatch(author -> email.equals(author.getEmail())))
                .collect(Collectors.toList());
    }
}
