package org.example.statistic.businessLogic;

import org.example.statistic.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class statistic {
    List<Movie> listMovies=new ArrayList<>();//questa lista è un esempip


    public int numberOfMovies(){
        return listMovies.size();
    }

    public double averageMoviesTime(){
        return listMovies.stream()
                .mapToDouble(movie -> movie.getRuntime())
                .average();

    }

}
