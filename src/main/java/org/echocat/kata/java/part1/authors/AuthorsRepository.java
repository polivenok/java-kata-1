package org.echocat.kata.java.part1.authors;

import org.echocat.kata.java.part1.data.DataReader;

import java.io.IOException;
import java.util.List;

public class AuthorsRepository {

    private final String resourceName;
    private final DataReader dataReader;

    public AuthorsRepository(DataReader dataReader, String resourceName) {
        this.dataReader = dataReader;
        this.resourceName = resourceName;
    }

    public List<Author> getAllAuthors() throws IOException {
        return dataReader.readData(resourceName, Author.class);
    }


}
