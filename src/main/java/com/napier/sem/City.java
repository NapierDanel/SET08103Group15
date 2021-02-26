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

    public ResultSet getAllCitiesInWorld(String limit)
    {
        try
        {
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
                    "SELECT Name, Population "
                            + "FROM city "
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

    public ResultSet getCitiesInContinent(String continent, String limit)
    {
        try
        {
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
                    "Select City.Name, City.Population "
                            + "FROM city "
                            + "INNER JOIN Countries ON city.CountryCode = country.Code "
                            + "WHERE country.continent = "
                            + continent
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

    public ResultSet getCitiesInRegion(String region, String limit)
    {
        try
        {
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
                    "Select City.Name, City.Population "
                            + "FROM city "
                            + "INNER JOIN Countries ON city.CountryCode = country.Code "
                            + "WHERE country.Region = "
                            + region
                            + " "
                            + "ORDER BY city.Population DESC"
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

    public ResultSet getCitiesInCountry(String country, String limit)
    {
        try
        {
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
                    "Select City.Name, City.Population "
                            + "FROM city "
                            + "INNER JOIN Countries ON city.CountryCode = country.Code "
                            + "WHERE country.Name = "
                            + country
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

    public ResultSet getCitiesInDistrict(String district, String limit)
    {
        try
        {
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
                    "Select Name, Population "
                            + "FROM city "
                            + "WHERE district = "
                            + district
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