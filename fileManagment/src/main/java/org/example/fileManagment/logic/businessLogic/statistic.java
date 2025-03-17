package org.example.fileManagment.logic.businessLogic;

import org.example.fileManagment.logic.models.Movie;
import org.example.fileManagment.logic.models.Person;
import org.example.fileManagment.utilities.FileManagementUtilities;

import java.util.*;
import java.util.stream.Collectors;

public class statistic {
    private List<Movie> listMovies = new ArrayList<>(); // Lista di film


    public statistic(String pathIn){
        listMovies=FileManagementUtilities.readFromCSV(pathIn);
    }

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
        // Step 1: Group per direttore e calcolo media
        Map<Person, Double> avgRatings = listMovies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getDirector,
                        Collectors.averagingDouble(Movie::getIMDBRating)
                ));

        // Step 2: trovare direttore con rating più alto
        Person bestDirector = Collections.max(avgRatings.entrySet(), Map.Entry.comparingByValue()).getKey();

        return bestDirector;
    }

    public Person mostPresentActor() {
        Map<Person, Long> starCounts = listMovies.stream()
                .flatMap(movie -> Arrays.stream(movie.getStars())) // Converti array in stream
                .collect(Collectors.groupingBy(star -> star, Collectors.counting()));

        return starCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }


    private int cntPresenze(Person personSrc){
        return Collections.frequency(listMovies,personSrc);
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
