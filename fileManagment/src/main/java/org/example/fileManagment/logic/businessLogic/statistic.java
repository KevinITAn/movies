package org.example.fileManagment.logic.businessLogic;

import org.example.fileManagment.logic.models.Movie;
import org.example.fileManagment.logic.models.Person;
import org.example.fileManagment.utilities.FileManagementUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class statistic {
    private List<Movie> listMovies = new ArrayList<>(); // Lista di film


    public statistic(){
        listMovies=FileManagementUtilities.readFromCSV("C:\\Users\\kevin\\Documents\\GitHub\\movies\\fileManagment\\imdb_top_1000.csv");
    }

    public int numberOfMovies() {
        return listMovies.size();
    }

    public double averageMoviesTime() { // 122,...
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
        return null;
    }

    private int cntPresenze(Person personSrc){
        for(Movie movieTmp : listMovies){

        }
        return 1;
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
