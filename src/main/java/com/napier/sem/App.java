package com.napier.sem;

import java.sql.*;

public class App {

    public static void main(String[] args)
    {

        // Create a new DatabaseLink class, containing connect and disconnect functionality, and database interactiond
        DatabaseLink db = new DatabaseLink();

        DatabaseLink.connInstance();

        Country country = new Country();
        country.getCountriesByPopulationDESC();


        // Disconnect from database
        db.disconnect();










    }




}
