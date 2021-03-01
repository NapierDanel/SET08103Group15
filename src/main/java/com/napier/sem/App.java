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



        // Disconnect from database
        db.disconnect();

        System.out.println("Disconnected from the database");


    }




}