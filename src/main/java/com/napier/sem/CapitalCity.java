package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

// This class will create the CapitalCity objects, for later use
class CapitalCity extends City{

    public CapitalCity getCapitalcity(int id)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT id, name, countryCode, district, population "
                            + "FROM city "
                            + "WHERE id = " + id;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                CapitalCity capcity = new CapitalCity();
                capcity.id = rset.getInt("id");
                capcity.name = rset.getString("name");
                capcity.countryCode = rset.getString("countryCode");
                capcity.population = rset.getInt("population");


                return capcity;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital City details");
            return null;
        }
    }
}



