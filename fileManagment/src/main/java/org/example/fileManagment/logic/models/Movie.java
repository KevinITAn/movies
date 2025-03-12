package org.example.fileManagment.logic.models;

public class Movie {
    private final String posterLink;
    private final String seriesTitle ;
    private final int releasedYear;
    private final String certificate;
    private final double runtime;
    private final String genre;
    private final double IMDBRating;
    private final String overview;
    private final String metaScore;

    //direcctor
    private Person director;
    //per salvare le start max 4

    private Person[] stars=new Person[4];
    private int noOfVotes;
    private String gross;

    public Movie(String posterLink, String seriesTitle, int releasedYear, String certificate, double runtime, String genre, double IMDBRating, String overview, String metaScore, Person director, Person[] stars, int noOfVotes, String gross) {
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

    public String getPosterLink() {
        return posterLink;
    }

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public String getCertificate() {
        return certificate;
    }

    public double getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public double getIMDBRating() {
        return IMDBRating;
    }

    public String getOverview() {
        return overview;
    }

    public String getMetaScore() {
        return metaScore;
    }

    public Person getDirector() {
        return director;
    }

    public Person[] getStars() {
        return stars;
    }

    public int getNoOfVotes() {
        return noOfVotes;
    }

    public String getGross() {
        return gross;
    }
}
