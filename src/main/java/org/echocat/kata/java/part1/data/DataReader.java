package org.echocat.kata.java.part1.data;

import java.io.IOException;
import java.util.List;

public interface DataReader {
    <T> List<T> readData(String resourceName, Class<T> clazz) throws IOException;
}
