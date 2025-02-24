package org.example.statistic.models;
import java.util.Optional;

public class Movie {
    private String posterLink;
    private String seriesTitle ;
    private int releasedYear;
    private String certificate;
    private String runtime;
    private String genre;
    private double IMDBRating;
    private String overview;
    private String metaScore;

    //direcctor
    private Person director;
    //per salvare le start max 4

    private Optional<Person>[] stars=new Optional[4];
    private int noOfVotes;
    private String gross;

    public Movie(String posterLink, String seriesTitle, int releasedYear, String certificate, String runtime, String genre, double IMDBRating, String overview, String metaScore, Person director, Optional<Person>[] stars, int noOfVotes, String gross) {
        this.posterLink = posterLink;
        this.seriesTitle = seriesTitle;
        this.releasedYear = releasedYear;
        this.certificate = certificate;
        this.runtime = runtime;
        this.genre = genre;
        this.IMDBRating = IMDBRating;
        this.overview = overview;
        this.metaScore = metaScore;
        this.director = director;
        this.stars = stars;
        this.noOfVotes = noOfVotes;
        this.gross = gross;
    }
}
