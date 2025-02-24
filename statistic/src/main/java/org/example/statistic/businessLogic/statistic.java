package org.example.statistic.businessLogic;

import org.example.statistic.models.Movie;
import org.example.statistic.models.Person;

import java.util.ArrayList;
import java.util.List;

public class statistic {
    List<Movie> listMovies=new ArrayList<>();//questa lista è un esempio


    public int numberOfMovies(){
        return listMovies.size();
    }

    public double averageMoviesTime(){
        return listMovies.stream()
                .mapToDouble(movie -> movie.getRuntime())
                .average().getAsDouble();
    }

    public Person bestDirector(){
        return
    }

    public Person  mostPresentActor(){

    }

    public Person mostProductiveYears(){

    }

}
