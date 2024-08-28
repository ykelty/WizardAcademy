package com.mathking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;


/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        System.out.println("USERNAME " + username);
        if (username == null || username.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing username parameter");
            return;
        }
        
        try (Connection conn = DatabaseUtil.getConnection();
        	     PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_scores WHERE username = ? ORDER BY score DESC, time_taken ASC")) {
        	    stmt.setString(1, username);
        	    System.out.println(stmt.toString());
        	    ResultSet rs = stmt.executeQuery();
        	    List<ScoreEntry> scores = new ArrayList<>();
        	    
        	    int totalScore = 0;
        	    
        	    while (rs.next()) {
        	        scores.add(new ScoreEntry(username, rs.getInt("score"), rs.getDouble("time_taken")));
        	        totalScore = totalScore + rs.getInt("score");
        	        
        	    }
        	    
        	    int userLevel = (totalScore * 2) + 100;
        	    
        	    String json = new Gson().toJson(scores);
        	    response.setContentType("application/json");
        	    response.setCharacterEncoding("UTF-8");
        	    response.getWriter().write(json);
        	} catch (Exception e) {
        	    e.printStackTrace();
        	    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving scores");
        	}
    }

    static class ScoreEntry {
        private int score;
        private double time;
        private String username;
        
        public ScoreEntry(String username, int score, double time) {
            this.username = username;
        	this.score = score;
            this.time = time;
        }

        // Getters
        public String getUsername() {return username;}
        public int getScore() { return score; }
        public double getTime() { return time; }
    }
}
