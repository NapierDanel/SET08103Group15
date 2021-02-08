package com.napier.sem;

import java.sql.*;

public class App {

    public static void main(String[] args)
    {
        // Create new Application
        DatabaseLink db = new DatabaseLink();

        System.setProperty("file.encoding","UTF-32");

        // Connect to database
        db.connect();
        System.out.println("Boo yah!, it connected");

        System.out.println("Please enter the city ID you want");

        for(int i = 1; i < 500; i++)
        {
            System.out.println(db.getCity(i).name + " " + db.getCity(i).population);
        }


        int ID = 5;







        // Disconnect from database
        db.disconnect();










    }




}
