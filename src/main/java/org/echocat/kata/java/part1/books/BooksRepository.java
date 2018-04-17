package org.echocat.kata.java.part1.books;

import org.echocat.kata.java.part1.library.LibraryRepository;
import org.echocat.kata.java.part1.authors.Author;
import org.echocat.kata.java.part1.authors.AuthorsRepository;
import org.echocat.kata.java.part1.data.BookCSVData;
import org.echocat.kata.java.part1.data.DataReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.echocat.kata.java.part1.authors.AuthorUtils.filterAuthorsByEmail;

public class BooksRepository extends LibraryRepository<Book> {

    private final DataReader dataReader;
    private final String booksResourceName;
    private final AuthorsRepository authorsRepository;


    public BooksRepository(DataReader dataReader, String booksResourceName, AuthorsRepository authorsRepository) {
        this.dataReader = dataReader;
        this.booksResourceName = booksResourceName;
        this.authorsRepository = authorsRepository;

    }

    public List<Book> getAll() throws IOException {
        List<BookCSVData> rawBooks = dataReader.readData(booksResourceName, BookCSVData.class);
        List<Author> authors = authorsRepository.getAllAuthors();
        return rawBooks.stream()
                .map(rawData -> Book.builder()
                        .title(rawData.getTitle())
                        .description(rawData.getDescription())
                        .isbn(rawData.getIsbn())
                        .authors(filterAuthorsByEmail(authors, rawData.getAuthors()))
                        .build()).collect(Collectors.toList());
    }


}
