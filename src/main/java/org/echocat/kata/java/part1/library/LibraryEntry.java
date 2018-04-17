package org.echocat.kata.java.part1.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.echocat.kata.java.part1.authors.Author;

import java.util.List;

@Data
@AllArgsConstructor
public abstract class LibraryEntry {
    private String title;
    private String isbn;
    private List<Author> authors;
}
