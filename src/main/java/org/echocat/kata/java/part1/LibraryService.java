package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.books.Book;
import org.echocat.kata.java.part1.books.BooksRepository;
import org.echocat.kata.java.part1.magazines.Magazine;
import org.echocat.kata.java.part1.magazines.MagazineRepository;

import java.io.IOException;
import java.util.*;

//FIXME: sorry, only console default output, no fancy formaters or customizable outputs
public class LibraryService {

    private final BooksRepository booksRepository;
    private final MagazineRepository magazineRepository;

    public LibraryService(BooksRepository booksRepository, MagazineRepository magazineRepository) {
        this.booksRepository = booksRepository;
        this.magazineRepository = magazineRepository;
    }

    public void printAllEntries() throws IOException {

        List<Book> allBooks = booksRepository.getAll();
        printLibraryEntries(allBooks);
        System.out.println("ALL Magazines:");
        List<Magazine> allMagazines = magazineRepository.getAll();
        printLibraryEntries(allMagazines);

    }

    public void printAllEntriesSortedByTitle() throws IOException {
        Set<LibraryEntry> allEntries = new TreeSet<>(Comparator.comparing(LibraryEntry::getTitle));
        allEntries.addAll(booksRepository.getAll());
        allEntries.addAll(magazineRepository.getAll());
        printLibraryEntries(allEntries);

    }

    public void printLibraryEntries(Collection<? extends LibraryEntry> entries) {
        entries.forEach(System.out::println);
    }


    public LibraryEntry findByIsbn(String isbn) throws IOException {
        return booksRepository.findByIsbn(isbn).orElse(magazineRepository.findByIsbn(isbn).orElseThrow(() ->  new IllegalArgumentException("No isbn matching")));
    }

    public List<LibraryEntry> findByEmail(String email) throws IOException {
        List<LibraryEntry> matchedEntries = new ArrayList<>();
        matchedEntries.addAll(booksRepository.findByEmail(email));
        matchedEntries.addAll(magazineRepository.findByEmail(email));
        return matchedEntries;
    }

}
