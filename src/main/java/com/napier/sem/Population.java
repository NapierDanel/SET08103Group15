package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

public class Population {

    public void getWorldPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(population) AS population "
                            + "FROM country ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {
                System.out.println(rset.getDouble("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }

    public void getContinentPopulation(String continentName) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT continent, SUM(population) AS population "
                            + "FROM country "
                            + "WHERE continent = " + '\''+ continentName + '\'';
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {
                System.out.println(rset.getString("continent") + "    " +
                        rset.getInt("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }

    public void getRegionPopulation(String regionName) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT region, SUM(population) AS population "
                            + "FROM country "
                            + "WHERE region = " + '\''+ regionName + '\'';
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {
                System.out.println(rset.getString("region") + "    " +
                        rset.getInt("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
    }

    public void getCountryPopulation(String code) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM country "
                            + "WHERE code = " + '\''+ code + '\'';
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {
                System.out.println(rset.getString("name") + "    " +
                        rset.getInt("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
    }

    public void getDistrictPopulation(String districtName) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT district, SUM(population) AS population "
                            + "FROM city "
                            + "WHERE district = " + '\''+ districtName + '\'';
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {
                System.out.println(rset.getString("district") + "    " +
                        rset.getInt("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }

    public void getCityPopulation(int id) {
        try {
            // Create an SQL statement
            Statement stmt = DatabaseLink.connInstance().createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population "
                            + "FROM city "
                            + "WHERE id = " + id;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {
                System.out.println(rset.getString("name") + "    " +
                        rset.getInt("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
        }
    }

}
