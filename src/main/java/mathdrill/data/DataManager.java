package mathdrill.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mathdrill.util.*;
import java.util.Properties;
import java.io.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Noetic Learning </p>
 * @author Li Kelty
 * @version 1.0
 */

public class DataManager {
 


  public DataManager() {
  }

  static {
    try{
     
    }
    catch (Exception e){
      System.out.println("Problem in Creating logWriter:"+e.getMessage());
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    Connection con = null;

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mathdrill", "root", "$cheese");
 //     con = DriverManager.getConnection("jdbc:mysql://localhost/mathdrill" ,"joe", "music");

      if(!con.isClosed())
        System.out.println("Successfully connected to " +
          "MySQL server using TCP/IP...");

    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      
    }
    return con;
  }
 public static void close(Connection conn){
	  
	  if (conn!=null)
		  try {conn.close(); } catch (SQLException e) { /* ignored */} 
	  
  }
  public static void close(ResultSet rs){
	  
	  if (rs!=null)
		  try {rs.close(); } catch (SQLException e) { /* ignored */} 
	  
  }
  public static void close(Statement sm){
	  
	  if (sm!=null)
		  try {sm.close(); } catch (SQLException e) { /* ignored */} 
	  
  }
  public static void main(String args[]) {
    getConnection();
  }

}