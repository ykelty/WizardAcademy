package com.mathking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDatabase {
    // Adjust the DB_URL to match your MySQL database's location, username, and password
	
	// uncomment when pushing to server
	private static final String DB_URL = "jdbc:mysql://localhost:3306/WizardMathAcademy"; // MySQL URL and db name
    private static final String USER = "root"; // MySQL username
    private static final String PASS = "$cheese"; // MySQL password
	
	
	//private static final String DB_URL = "jdbc:sqlite:WizardMathAcademy.db"; //comment out when pushing to server
    
	
    static {
        // Load the MySQL JDBC driver
        try {
        	
        	//uncomment when pushing to server
            Class.forName("com.mysql.jdbc.Driver"); 
            
            
            
        	//Class.forName("org.sqlite.JDBC"); //comment out when pushing to server
        	
        	
        	
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC driver not found: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
        // Initialize database tables
        initializeDatabase();
    }

    public static Connection getConnection() throws SQLException {
    	// uncomment when pushing to server
    	return DriverManager.getConnection(DB_URL, USER, PASS);
    	
    	
    	//return DriverManager.getConnection(DB_URL); //comment out when pushing to server
    }


    private static void initializeDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            // Create table if it does not exist
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                         "username VARCHAR(255) NOT NULL," +
                         "level INT NOT NULL);");
        } catch (SQLException e) {
            System.err.println("Error initializing the database: " + e.getMessage());
        }
    }
}
