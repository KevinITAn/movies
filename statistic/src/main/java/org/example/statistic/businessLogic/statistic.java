package org.example.statistic.businessLogic;

import org.example.statistic.models.Movie;
import org.example.statistic.models.Person;

import java.util.*;
import java.util.stream.Collectors;

public class statistic {
    private List<Movie> listMovies = new ArrayList<>(); // Lista di film

    public int numberOfMovies() {
        return listMovies.size();
    }

    public double averageMoviesTime() {
        return listMovies.stream()
                .mapToDouble(Movie::getRuntime)
                .average()
                .orElse(0.0);
    }

    public Person bestDirector() {
        return null;//TODO
    }

    public Person mostPresentActor() {
        //TODO fare la mappa<actor,numeroDiPresenza> limitare a 1
    }

    public int mostProductiveYear() {
        return listMovies.stream()
                .collect(Collectors.groupingBy(Movie::getReleasedYear, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(-1);
    }
}
