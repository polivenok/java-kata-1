package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.authors.AuthorsRepository;
import org.echocat.kata.java.part1.books.BooksRepository;
import org.echocat.kata.java.part1.data.CSVReader;
import org.echocat.kata.java.part1.data.DataReader;
import org.echocat.kata.java.part1.magazines.MagazineRepository;

import java.io.IOException;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {

    public static void main(String[] args) throws IOException {
        DataReader csvReader = new CSVReader();
        AuthorsRepository authorsRepository = new AuthorsRepository(csvReader, "org/echocat/kata/java/part1/data/authors.csv");
        BooksRepository booksRepository = new BooksRepository(csvReader, "org/echocat/kata/java/part1/data/books.csv", authorsRepository);
        MagazineRepository magazineRepository = new MagazineRepository(csvReader, "org/echocat/kata/java/part1/data/magazines.csv", authorsRepository);

        LibraryService libraryService = new LibraryService(booksRepository, magazineRepository);
        System.out.println("All Books and Magazines:");
        libraryService.printAllEntries();
        System.out.println("All Books and Magazines sorted by title:");
        libraryService.printAllEntriesSortedByTitle();

        System.out.println("Magazine with isbn=2547-8548-2541");
        System.out.println(libraryService.findByIsbn("2547-8548-2541"));

        System.out.println("Entries by email: null-walter@echocat.org");
        libraryService.printLibraryEntries(libraryService.findByEmail("null-walter@echocat.org"));


    }

}
