package mathdrill.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mathdrill.user.Assignment;
import mathdrill.user.User;

public class AssignmentDao extends DataManager {

	/**
	 * 
	 * @param userId
	 * @return null if assignment doesn't exist.
	 * @throws SQLException
	 */
	public Assignment selectByUserId(int userId) throws SQLException {
		Assignment assignment = null;

		String query = "Select * from assignment where user_id=?";
		try (Connection con = DataManager.getConnection(); PreparedStatement statement = con.prepareStatement(query)) {
			statement.setInt(1, userId);
			
			ResultSet result = statement.executeQuery();
			if (result.first() && result.isFirst()) {
				assignment = new Assignment();
				assignment.setWorksheetData(result.getString("worksheet_data"));
				assignment.setAssignmentName(result.getString("name"));
			} else {
				String exceptionMsg = "Assignment doesn't exist. ";
				
			}
		}

		return assignment;
	}

	public void insert(User user, String worksheetData, String assignmentName) throws SQLException {
		String sqlStatement = "insert into assignment (user_id,name,worksheet_data,saved_date) values (?,?,?,?)";

		try (Connection con = DataManager.getConnection();
				PreparedStatement statement = con.prepareStatement(sqlStatement)) {
			statement.setInt(1, user.getUserId());
			statement.setString(2, assignmentName);
			statement.setString(3, worksheetData);
			java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
			statement.setDate(4, today);

			
			statement.executeUpdate();

		}

	}

	public void update(User user, String worksheetData, String assignmentName) throws SQLException {

		String sqlStatement = "update assignment set worksheet_data=?, name=?, saved_date=? where user_id=?";

		try (Connection con = DataManager.getConnection();
				PreparedStatement statement = con.prepareStatement(sqlStatement)) {
			statement.setString(1, worksheetData);
			statement.setString(2, assignmentName);
			java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
			statement.setDate(3, today);
			statement.setInt(4, user.getUserId());

			
			statement.executeUpdate();

		}
	}

}
