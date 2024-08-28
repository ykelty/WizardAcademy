package com.mathking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ScoreManager {

    public static void insertScore(String username, int score, double timeTaken) {
        String sql = "INSERT INTO user_scores(username, score, time_taken) VALUES(?, ?, ?);";
        System.out.println("ENTERING SCORE");
        try (Connection conn = DatabaseUtil.getConnection();
        	
        	PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setInt(2, score);
            pstmt.setDouble(3, timeTaken);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting score: " + e.getMessage());
        }
    }
}