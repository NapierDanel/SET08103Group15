package com.napier.sem;


import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The City class contains the methods for manipulating the database and retrieving out the requested data
 */
public class City {

    /**
     * Allows for a data structure of type city to be created
     */
    int id;
    String name;
    String countryCode;
    String district;
    int population;


    /**
     * Get a specific city within the database with its ID
     *
     * @param id    The id of the city within the database
     * @return      Return an object of type city, aka the requested city
     */




    /**
     * Get all the Cities in the world within the database
     *
     * @param limit     Can take a string (integer), as a limit, with zero being no limit
     * @return          Return a ResultSet which can be used to print data to the screen or exported to a .csv file
     */
    public ResultSet getAllCitiesInWorld(String limit)
    {
        try
        {
            // Create an SQL statement
            if(limit == null)
            {
                NullPointerException nullPointerException = new NullPointerException();
                throw nullPointerException;
            }

            Statement stmt = DatabaseLink.connInstance().createStatement();

            int limitInt = Integer.parseInt(limit);

            if(limitInt == 0)
            {
                limit = "";
            }
            else
            {
                limit = "LIMIT " + limitInt;

            }


            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name AS 'CountryName', city.District, city.Population "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "ORDER BY Population DESC "
                            + limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            return rset;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get all city details");
            return null;
        }
    }

    /**
     * Get all the Cities in a specific continent within the database
     *
     * @param continent Can take a string (continent name)
     * @param limit     Take a string (integer) as a limit, with zero being no limit
     * @return          Return a ResultSet which can be used to print data to the screen or exported to a .csv file
     */
    public ResultSet getCitiesInContinent(String continent, String limit)
    {
        try
        {
            if(continent == null || limit == null)
            {
                NullPointerException nullPointerException = new NullPointerException();
                throw nullPointerException;
            }

            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            int limitInt = Integer.parseInt(limit);

            if(limitInt == 0)
            {
                limit = "";
            }
            else
            {
                limit = "LIMIT " + limitInt;

            }


            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name AS 'CountryName', city.District, city.Population "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Continent = " + '\'' + continent + '\''
                            + " "
                            + "ORDER BY city.Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned

            return rset;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Get all the Cities in a specific region within the database
     *
     * @param region Can take a string (region name)
     * @param limit     Take a string (integer) as a limit, with zero being no limit
     * @return          Return a ResultSet which can be used to print data to the screen or exported to a .csv file
     */
    public ResultSet getCitiesInRegion(String region, String limit)
    {
        try
        {
            if(region == null || limit == null)
            {
                NullPointerException nullPointerException = new NullPointerException();
                throw nullPointerException;
            }
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            int limitInt = Integer.parseInt(limit);

            if(limitInt == 0)
            {
                limit = "";
            }
            else
            {
                limit = "LIMIT " + limitInt;

            }

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name AS 'CountryName', city.District, city.Population "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Region = " + '\'' + region + '\''
                            + " "
                            + "ORDER BY city.Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned

            return rset;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    /**
     * Get all the Cities in a specific Country within the database
     *
     * @param country Can take a string (country name)
     * @param limit     Take a string (integer) as a limit, with zero being no limit
     * @return          Return a ResultSet which can be used to print data to the screen or exported to a .csv file
     */
    public ResultSet getCitiesInCountry(String country, String limit)
    {
        try
        {
            if(country == null || limit == null)
            {
                NullPointerException nullPointerException = new NullPointerException();
                throw nullPointerException;
            }
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            int limitInt = Integer.parseInt(limit);

            if(limitInt == 0)
            {
                limit = "";
            }
            else
            {
                limit = "LIMIT " + limitInt;

            }


            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name AS 'CountryName', city.District, city.Population "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Name = " + '\'' + country + '\''
                            + " "
                            + "ORDER BY city.Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned

            return rset;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    /**
     * Get all the Cities in a specific district within the database
     *
     * @param district Can take a string (district name)
     * @param limit     Take a string (integer) as a limit, with zero being no limit
     * @return          Return a ResultSet which can be used to print data to the screen or exported to a .csv file
     */
    public ResultSet getCitiesInDistrict(String district, String limit)
    {
        try
        {
            if(district == null || limit == null)
            {
                NullPointerException nullPointerException = new NullPointerException();
                throw nullPointerException;
            }
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            int limitInt = Integer.parseInt(limit);

            if(limitInt == 0)
            {
                limit = "";
            }
            else
            {
                limit = "LIMIT " + limitInt;

            }


            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name AS 'CountryName', city.District, city.Population "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE District = " + '\'' + district + '\''
                            + " "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned

            return rset;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

}