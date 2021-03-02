package com.napier.sem;

import java.sql.*;

/**
 * Containing connect and disconnect functionality, and database interactions.
 */
public class DatabaseLink
{
    // Connect to the database
    private static Connection con = null;

    /**
     * @return the connection instance
     */
    public static Connection connInstance() {
        if (con == null) {
            try
            {
                // Load Database driver
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (ClassNotFoundException e)
            {
                System.out.println("Could not load SQL driver");
                System.exit(-1);
            }

            int retries = 40;
            for (int i = 0; i < retries; ++i)
            {
                System.out.println("Connecting to database...");
                try
                {
                    // Wait a bit for db to start
                    Thread.sleep(30000);
                    // Connect to database
                    con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                    System.out.println("Successfully connected");
                    break;
                }
                catch (SQLException sqle)
                {
                    System.out.println("Failed to connect to database attempt " + i);
                    System.out.println(sqle.getMessage());
                }
                catch (InterruptedException ie)
                {
                    System.out.println("Thread interrupted? Should not happen.");
                }
            }
        }
        return con;
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
                System.out.println("Connect Successfully closed");
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }























}
