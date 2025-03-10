package org.example.fileManagment.utilities;

import org.apache.commons.csv.*;
import org.example.fileManagment.logic.businessLogic.statistic;
import org.example.fileManagment.logic.models.Movie;
import org.example.fileManagment.logic.models.Person;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FileManagementUtilities {



    private static String inputFile;
    private static String outputFile;

    //TODO cambiare la firma del metodo per far returnare una lista di oggetti presi dal file
    static public List<Movie> readFromCSV(String inputFile) {
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

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    static public boolean writeOnCSV() throws IOException {
        readConfiguration();
        File fileOut;

        //se path==null
        try{
              fileOut= new File(outputFile);
        }catch (NullPointerException e){
            System.out.println("Path is empty so I write in "+inputFile);
            fileOut=new File(inputFile);
        }

        //se path non esiste
        if(!fileOut.exists() ){
             //directory
            fileOut.getParentFile().mkdir();
            //file
            fileOut.createNewFile();

            System.out.println("statistics written to"+fileOut.getAbsolutePath());
        }else{
                 //esiste                                                                        
                System.out.println("statistics overwritten onto"+fileOut.getAbsolutePath());   }





        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut))) {
            CSVPrinter printer = new CSVPrinter(bw, CSVFormat.DEFAULT.withHeader(
                "Number_Of_Movies", "Average_Movies_Time", "Best_Director", "Most_Present_Actor", "Most_Productive_Year"));

            statistic x = new statistic(inputFile);

            printer.print(x.numberOfMovies());
            printer.print(x.averageMoviesTime());
            printer.print(x.bestDirector());
            printer.print(x.mostPresentActor());
            printer.print(x.mostProductiveYear());

            printer.flush();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    static private void readConfiguration(){
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
