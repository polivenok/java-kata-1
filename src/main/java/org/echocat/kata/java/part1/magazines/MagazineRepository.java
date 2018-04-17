package org.echocat.kata.java.part1.magazines;

import org.echocat.kata.java.part1.authors.Author;
import org.echocat.kata.java.part1.authors.AuthorsRepository;
import org.echocat.kata.java.part1.books.LibraryRepository;
import org.echocat.kata.java.part1.data.DataReader;
import org.echocat.kata.java.part1.data.MagazineCSVData;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.echocat.kata.java.part1.authors.AuthorUtils.filterAuthorsByEmail;

public class MagazineRepository extends LibraryRepository<Magazine> {

    private final DataReader dataReader;
    private final String magazineResourceName;
    private final AuthorsRepository authorsRepository;


    public MagazineRepository(DataReader dataReader, String magazineResourceName, AuthorsRepository authorsRepository) {
        this.dataReader = dataReader;
        this.magazineResourceName = magazineResourceName;
        this.authorsRepository = authorsRepository;
    }

    public List<Magazine> getAll() throws IOException {
        List<MagazineCSVData> rawMagazines = dataReader.readData(magazineResourceName, MagazineCSVData.class);
        List<Author> authors = authorsRepository.getAllAuthors();
        return rawMagazines.stream()
                .map(rawData -> Magazine.builder()
                        .title(rawData.getTitle())
                        .isbn(rawData.getIsbn())
                        .authors(filterAuthorsByEmail(authors, rawData.getAuthors()))
                        .publishedAt(rawData.getPublishedAt())
                        .build()).collect(Collectors.toList());
    }

}
