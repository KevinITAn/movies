package org.example.fileManagment;


import org.example.fileManagment.logic.businessLogic.statistic;
import org.example.fileManagment.logic.models.Movie;
import org.example.fileManagment.utilities.FileManagementUtilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        FileManagementUtilities.writeOnCSV();
    }
}