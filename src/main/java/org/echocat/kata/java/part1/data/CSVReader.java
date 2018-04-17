package org.echocat.kata.java.part1.data;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CSVReader implements DataReader {

    public <T> List<T> parseCSV(InputStream stream, Class<T> clazz) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';');
        MappingIterator<T> mappingIterator = mapper.readerFor(clazz).with(schema)
                .readValues(stream);
        return mappingIterator.readAll();
    }

    @Override
    public <T> List<T> readData(String classPathResource, Class<T> clazz) throws IOException {
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(classPathResource)) {
            return parseCSV(inputStream, clazz);
        }
    }

}
