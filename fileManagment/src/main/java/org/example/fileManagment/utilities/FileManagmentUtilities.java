package org.example.fileManagment.utilities;


import java.io.*;
import java.util.Scanner;

public class FileManagmentUtilities {

    private static String inputFile;
    private static String outFile;

    static public void readFromCSV(String path) {
        String filePath = new File(path).getAbsolutePath();
        boolean isFirstLine = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                //intestazione
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                System.out.println(line);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    static public void readConfiguration(){
        try {
            File myObj = new File("fileManagment/preferences.txt");
            Scanner myReader = new Scanner(myObj);
            //controlli mancante
            inputFile= myReader.nextLine();
            outFile=myReader.nextLine();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(inputFile);
        System.out.println(outFile);
    }
}
