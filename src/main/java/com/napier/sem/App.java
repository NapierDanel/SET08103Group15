package com.napier.sem;

import java.sql.*;

/**
 * The main class where all other classes are instantiated
 */
public class App {

    /**
     * The main instantiates the main classes and creates a link to the database
     * @param args     Currently not in use
     */
    public static void main(String[] args)
    {

        // Create a new DatabaseLink class, containing connect and disconnect functionality, and database interactions
        DatabaseLink db = new DatabaseLink();

        // Connects to the database
        DatabaseLink.connInstance();

        // The following code gives an example of how the ResultSet datatype will be accessed
        City c = new City();

        ResultSet rset = c.getAllCitiesInWorld("20");

        try
        {
            while (rset.next())
            {
                System.out.println(rset.getString("name") + "    " + rset.getInt("population"));
            }

            System.out.println("Output complete");
        }
        catch (Exception e)
        {
            System.out.println("Not working");
        }

        // Disconnect from database
        db.disconnect();



    }




}