package org.echocat.kata.java.part1.books;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import org.echocat.kata.java.part1.library.LibraryEntry;
import org.echocat.kata.java.part1.authors.Author;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Book extends LibraryEntry {
    private String description;

    @Builder
    public Book(String title, String isbn, List<Author> authors, String description) {
        super(title, isbn, authors);
        this.description = description;
    }
}
