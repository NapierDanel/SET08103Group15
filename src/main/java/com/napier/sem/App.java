package com.napier.sem;

import java.sql.*;

public class App {

    public static void main(String[] args)
    {

        // Create a new DatabaseLink class, containing connect and disconnect functionality, and database interactiond
        DatabaseLink db = new DatabaseLink();


        DatabaseLink.connInstance();

        System.out.println("Looping through the first 500 cities within the database");


        // Loop through the first 500 entries in the database
        for(int i = 1; i < 500; i++)
        {
            System.out.println(db.getCity(i).name + " " + db.getCity(i).population);
        }


        // Disconnect from database
        db.disconnect();










    }




}
