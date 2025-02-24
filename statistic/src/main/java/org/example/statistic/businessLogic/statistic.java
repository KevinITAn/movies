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
        //su metaScore?
    }

    public Person  mostPresentActor(){

    }

    //prende tutti i actor
    private List<Person> getAllActor(){
        List<Person> personList=new ArrayList<>();
        for(Movie tmp:listMovies){

        }
    }

    public Person mostProductiveYears(){

    }

}
