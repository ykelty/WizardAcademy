package com.mathking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("Entered Login Servlet");
        DatabaseUtil db1 = new DatabaseUtil(); 
        
        System.out.println("beginning SCORE");
       
        // Add password handling and validation here
        request.getSession().setAttribute("username", username);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
