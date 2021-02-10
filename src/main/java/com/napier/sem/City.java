package com.napier.sem;


import java.sql.ResultSet;
import java.sql.Statement;

// This class will create the city objects, for later use
class City {
    int id;
    String name;
    String countryCode;
    String district;
    int population;


    public City getCity(int id)
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
                City city = new City();
                city.id = rset.getInt("id");
                city.name = rset.getString("name");
                city.countryCode = rset.getString("countryCode");
                city.district = rset.getString("district");
                city.population = rset.getInt("population");


                return city;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

















}