package org.example.fileManagment.utilities;

import org.apache.commons.csv.*;
import org.example.statistic.models.Movie;
import org.example.statistic.models.Person;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FileManagementUtilities {

    private static String inputFile;
    private static String outputFile;

    //TODO cambiare la firma del metodo per far returnare una lista di oggetti presi dal file
    static public void readFromCSV(String inputFile) {
        String filePath = new File(inputFile).getAbsolutePath();
        List<Movie> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            //permette di ottenere una mappatura del file CSV
            CSVParser parser = new CSVParser(br, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            for(CSVRecord record : parser) {
                String posterLink = record.get("Poster_Link");
                String seriesTitle = record.get("Series_Title");
                int releasedYear = Integer.parseInt(record.get("Released_Year"));
                String certificate = record.get("Certificate");
                double runtime = Double.parseDouble(record.get("Runtime").split(" ")[0]);
                String genre = record.get("Genre");
                double IMDBRating = Double.parseDouble(record.get("IMDB_Rating"));
                String overview = record.get("Overview");
                String metaScore = record.get("Meta_score");
                String director = record.get("Director");
                String star1 = record.get("Star1");
                String star2 = record.get("Star2");
                String star3 = record.get("Star3");
                String star4 = record.get("Star4");
                int noOfVotes = Integer.parseInt(record.get("No_of_Votes"));
                String gross = record.get("Gross");

                //ho pronti tutti i campi, ora devo creare gli oggetti movie(s)
                //TODO da togliere i commenti quando implementato il movie
                Person[] stars = {Person.buildPerson(star1), Person.buildPerson(star2), Person.buildPerson(star3), Person.buildPerson(star4)};
                list.add(new Movie(posterLink, seriesTitle, releasedYear, certificate, runtime, genre, IMDBRating, overview, metaScore, Person.buildPerson(director), stars,noOfVotes, gross));
            }

            System.out.println(list);


            //ho le stringhe che devono essere convertite in oggetti
            //TODO da togliere i commenti quando implementato il movie
            //list.add(new Movie(arr));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
    static public boolean writeOnCSV() {
        String filePath = new File(outputFile).getAbsolutePath();

        try (BufferedWriter wr = new BufferedWriter(new FileWriter(filePath))) {

        } catch (IOException e) {

        }
    }
*/
    static public void readConfiguration(){
        try {
            File myObj = new File("fileManagment/preferences.txt");
            Scanner myReader = new Scanner(myObj);
            //controlli mancante
            inputFile= myReader.nextLine();
            outputFile=myReader.nextLine();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "...\nTerminated.");
        }
        System.out.println(inputFile);
        System.out.println(outputFile);
    }
}
