package mathdrill.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SurveyDao extends DataManager {

	public void insert(String email, String question, String answer) throws SQLException {
		String exceptionMsg = "";

		String sqlStatement = "insert into survey (email,question, answer,date) values (?,?,?,?)";

		try (Connection con = DataManager.getConnection();
				PreparedStatement statement = con.prepareStatement(sqlStatement)) {

			java.sql.Date today = new java.sql.Date(System.currentTimeMillis());

			statement.setString(1, email);
			statement.setString(2, question);
			statement.setString(3, answer);
			statement.setDate(4, today);

			
			statement.executeUpdate();
		}
	}

}
