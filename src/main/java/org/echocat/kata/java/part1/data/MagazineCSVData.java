package org.echocat.kata.java.part1.data;

import lombok.Data;

import java.util.List;

@Data
public class MagazineCSVData {
    private String title;
    private String isbn;
    private List<String> authors;
    private String publishedAt;
}
