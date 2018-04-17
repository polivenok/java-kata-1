package org.echocat.kata.java.part1.magazines;

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
public class Magazine extends LibraryEntry {
    private String publishedAt;

    @Builder
    public Magazine(String title, String isbn, List<Author> authors, String publishedAt) {
        super(title, isbn, authors);
        this.publishedAt = publishedAt;
    }
}
