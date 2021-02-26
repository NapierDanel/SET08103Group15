package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// This class will create the CapitalCity objects, for later use
class CapitalCity extends City
{

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

    public void getCapCityWorldPop()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ci.Name AS 'CityName', country.Name AS 'CountryName', ci.population "
                            + "FROM city ci "
                            + "INNER JOIN country ON ci.ID=country.capital "
                            + "ORDER BY ci.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check one is returned
            while (rset.next())
            {
                System.out.println(rset.getString("CityName") + " " +
                        rset.getString("CountryName") + " " +
                        rset.getInt("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void getCapCityContPop()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();

            Scanner scanner = new Scanner(System.in);

            //User input continent name
            System.out.print("Please enter the continent you would like to search: ");
            String continentName = scanner.nextLine();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name AS 'CityName', country.Name AS 'CountryName', population, "
                            + "FROM city "
                            + "WHERE continent = " + '\''+ continentName + '\''
                            + "INNER JOIN country ON city.ID=country.capital "
                            + "ORDER BY population DESC";

            //Scanner scanner = new Scanner(System.in);

            //User input continent name
            //System.out.print("Please enter the continent you would like to search: ");
            //continentName = scanner.nextLine();

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check one is returned
            while (rset.next())
            {
                System.out.println(rset.getString("CityName") + " " +
                        rset.getString("CountryName") + " " +
                        rset.getDouble("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }
    public void getCapCityRegPop(String regionName)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name AS 'CityName', country.Name AS 'CountryName', population, "
                            + "FROM city "
                            + "WHERE region = " + '\''+ regionName + '\''
                            + "INNER JOIN country ON city.ID=country.capital "
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check one is returned
            while (rset.next())
            {
                System.out.println(rset.getString("CityName") + " " +
                        rset.getString("CountryName") + " " +
                        rset.getDouble("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }
}





