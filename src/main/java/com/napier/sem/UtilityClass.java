package com.napier.sem;

import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class UtilityClass {



    public void exportCSV(String filename, ResultSet rset)
    {
        try
        {

            // Adds file extension to the filename
            filename += ".csv";

            // Create a new fileWriter object
            FileWriter csvWriter = new FileWriter(filename);

            // Gets the ResultSets metadata
            ResultSetMetaData rsmd = rset.getMetaData();

            // Gets the number of columns of the ResultSet
            int numberOfColumns = rsmd.getColumnCount();

            // Checking its working
            System.out.println("Number of columns detected is " + numberOfColumns);

            // It builds the column names for the csv file
            for (int j = 1; j <= numberOfColumns; j++)
            {
                csvWriter.append(rsmd.getColumnName(j));
                csvWriter.append(",");

            }

            // New line added
            csvWriter.append("\n");



            // Go through every row of the ResultSet
            while (rset.next())
            {
                // Builds the .csv file
                for (int i = 1; i <= numberOfColumns; i++)
                {
                    csvWriter.append(rset.getString(i));
                    csvWriter.append(",");


                }

                // New line added
                csvWriter.append("\n");
            }

            // Flush and close the csvWriter
            csvWriter.flush();
            csvWriter.close();


            System.out.println("Output complete");
        }
        catch (Exception e)
        {
            System.out.println("Not working, this is the error");

            System.out.println(e.toString());
        }




    }






}
