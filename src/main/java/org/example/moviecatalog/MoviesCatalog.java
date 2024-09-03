package org.example.moviecatalog;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MoviesCatalog {

    private static final long LOWER_BOUND = 1990;
    private static final long UPPER_BOUND = 2000;

    public List<Movies> readCSV() throws IOException {
        ClassLoader loader = getClass().getClassLoader();
        File csvFile = new File("movies.csv");
        MappingIterator<Movies> mappingMovieIterator = new CsvMapper()
                .readerWithTypedSchemaFor(Movies.class)
                .readValues(csvFile);
        return mappingMovieIterator.readAll();
    }

    public Map<String,List<String>> getMovies(List<Movies> movies) {
        return movies.stream()
                .collect(Collectors
                        .groupingBy(Movies::getDate,Collectors.mapping(m -> m.getTitle() +"-"+m.getGenres(),Collectors.toList())
                        ));
    }

    public static void main(String[] args) throws IOException {
        /*MoviesCatalog moviesCatalog = new MoviesCatalog();
        List<Movies> movies = moviesCatalog.readCSV();
        Map<String, List<String>> hashMap = moviesCatalog.getMovies(movies);
        System.out.println(hashMap);
        hashMap.forEach((k, v) -> {
            if(Long.parseLong(k) >= LOWER_BOUND && Long.parseLong(k) <= UPPER_BOUND && v.stream().anyMatch(val -> val.equals("Children")))
            {
                System.out.println(v);
            }
        });*/

        Set<Integer> s = new HashSet<>();
        s.add(79);
        s.add(42);
        s.add(21);
        s.add(11);
        s.add(36);
        s.add(62);
        System.out.println("s before = " + s);
        Set<Integer> set = s.stream()
                .sorted()
                .collect(Collectors.toSet());
       // HashSet<Integer> sortedSet=new HashSet(list);
        System.out.println("s after = " +set);
        //System.out.println("list after = " +list);
    }
}
