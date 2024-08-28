package com.mathking;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mathking.ProfileServlet.ScoreEntry;




public class LeaderboardServlet extends HttpServlet {
    private List<Result> leaderboard = Collections.synchronizedList(new LinkedList<>());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assuming the parameters are sent as form data or via URL query parameters
        String username = request.getParameter("username");
        int score = Integer.parseInt(request.getParameter("score"));
        double time = Double.parseDouble(request.getParameter("time"));
        ScoreManager scorer = new ScoreManager();
        scorer.insertScore(username, score, time);
        Result newResult = new Result(username, score, time);
        leaderboard.add(newResult);

        // Sorting leaderboard: highest scores first, if scores are equal, lowest time first
        leaderboard.sort(Comparator.comparing(Result::getScore).reversed());

        response.setContentType("application/json");
        response.getWriter().write("{\"message\": \"Result added successfully\"}");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        /*
        response.setContentType("application/json");
        StringBuilder sb = new StringBuilder("[");
        synchronized (leaderboard) {
            for (int i = 0; i < leaderboard.size(); i++) {
                Result result = leaderboard.get(i);
                if (i > 0) sb.append(",");
                sb.append(result.toJson());
            }
        }
        sb.append("]");
        response.getWriter().write(sb.toString()); 
        */
    	
    	try (Connection conn = DatabaseUtil.getConnection();
       	     PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_scores ORDER BY score DESC, time_taken ASC LIMIT 10")) {
       	    ResultSet rs = stmt.executeQuery();
       	    List<ScoreEntry> scores = new ArrayList<>();
       	    while (rs.next()) {
       	        scores.add(new ScoreEntry(rs.getString("username"), rs.getInt("score"), rs.getDouble("time_taken")));
       	    }
       	    String json = new Gson().toJson(scores);
       	    response.setContentType("application/json");
       	    response.setCharacterEncoding("UTF-8");
       	    response.getWriter().write(json);
       	} catch (Exception e) {
       	    e.printStackTrace();
       	    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving scores");
       	}
    }

    private static class Result {
        private String username;
        private int score;
        private double time;

        public Result(String username, int score, double time) {
            this.username = username;
            this.score = score;
            this.time = time;
        }
        
        public String getUsername() {
        	return username;
        }

        public int getScore() {
            return score;
        }

        public double getTime() {
            return time;
        }

        public String toJson() {
            return String.format("{\"username\": \"%s\", \"score\": %d, \"time\": %.2f}", username, score, time);
        }
    }
}

