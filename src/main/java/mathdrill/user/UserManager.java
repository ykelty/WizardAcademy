package mathdrill.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;



import mathdrill.data.AssignmentDao;
import mathdrill.data.DataManager;
import mathdrill.data.util.QueryBuilder;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: Noetic Learning
 * </p>
 * 
 * @author Li Kelty
 * @version 1.0
 */

public class UserManager extends BaseManager {

	public UserManager() {
	}

	public static User login(String user_name, String password) throws UserException {
		User user = null;
		String exceptionMsg = "";

		Connection con = null;
		Statement statement = null;

		try {

			con = DataManager.getConnection();
			statement = con.createStatement();
			QueryBuilder query = new QueryBuilder("Select * from user where user_name= ? and password = ? ;");
			query.AddParameter(makeStringParam(user_name));
			query.AddParameter(makeStringParam(password));
			String sqlStatement = query.getQueryString();
			System.out.println(sqlStatement);
			
			ResultSet result = statement.executeQuery(sqlStatement);
			if (result.first() && result.isFirst()) {

				user = new User();
				user.setUserId(result.getInt("id"));
				user.setUserName(result.getString("user_name"));
				user.setEmail(result.getString("email").toLowerCase());
				user.setPassword(result.getString("password"));
				user.setStatus(result.getString("status"));
				user.setPhone(result.getString("phone"));
				user.setStatus_effective_start_date(getUtilDate(result.getDate("status_effective_start_date")));
				user.setStatus_effective_end_date(getUtilDate(result.getDate("status_effective_end_date")));
				user.setPromotion_code(result.getString("promotion_code"));
				
			} else {
				System.out.println("Login Failed");
				exceptionMsg = "Login failed: invalid email or password.";
				
			}
		} catch (SQLException e) {
			user = null;
			System.out.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			exceptionMsg = "Login Failed: SQL error. Contact System Administrator";
			
		} catch (Exception e) {
			user = null;
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			exceptionMsg = "Login Failed: System error. Contact System Administrator";
			
		} finally {
			DataManager.close(statement);
			DataManager.close(con);
		}

		if (user == null)
			throw new UserException(exceptionMsg);

		return user;

	}

	public static User getUserByName(String userName) throws UserException {
		User account = null;
		String exceptionMsg = "";
		Connection con = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			con = DataManager.getConnection();
			statement = con.createStatement();
			QueryBuilder query = new QueryBuilder("Select * from user where user_name=?");
			query.AddParameter(makeStringParam(userName));
			String sqlStatement = query.getQueryString();
			System.out.println(sqlStatement);
			// logWriter.logDebugMessage(sqlStatement);
			
			result = statement.executeQuery(sqlStatement);
			if (result.first() && result.isFirst()) {
				account = new User();
				account.setUserId(result.getInt("id"));
				account.setUserName(result.getString("user_name"));
				account.setEmail(result.getString("email").toLowerCase());
				account.setPassword(result.getString("password"));
				account.setStatus(result.getString("status"));
				account.setPhone(result.getString("phone"));
				account.setStatus_effective_start_date(getUtilDate(result.getDate("status_effective_start_date")));
				account.setStatus_effective_end_date(getUtilDate(result.getDate("status_effective_end_date")));
			} else {
				exceptionMsg = "User name doesn't exist. ";
				
				throw new UserException(exceptionMsg);
			}
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			exceptionMsg = "Get UserByName Failed: SQL error:" + e.getMessage() + "  Contact System Administrator";
			
			throw new UserException(exceptionMsg);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			exceptionMsg = "Get UserByName Failed: System error:" + e.getMessage() + "  Contact System Administrator";
			
			throw new UserException(exceptionMsg);
		} finally {
			DataManager.close(statement);
			DataManager.close(con);
			DataManager.close(result);
		}

		return account;

	}

	public static User create(User account) throws UserException {
		String exceptionMsg = "";
		User u = null;
		Connection con = null;
		Statement statement = null;

		try {
			u = getUserByName(account.getUserName());
		} catch (UserException e) {
			u = null; // actuall this exception is our desired results!
		}

		if (u != null) {
			exceptionMsg = "CreateAccount Failed: User Name already exists:" + account.getUserName();
			throw new UserException(exceptionMsg);
		}

		try {
			con = DataManager.getConnection();
			statement = con.createStatement();

			account.setStatus("new");
			java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
			String sqlStatement = "insert into user (user_name,email,phone,password,promotion_code,referrer,status,status_effective_start_date,status_effective_end_date,created_date) values ("
					+ makeStringParam(account.getUserName()) + "," + makeStringParam(account.getEmail()) + ","
					+ makeStringParam(account.getPhone()) + "," + makeStringParam(account.getPassword()) + ","
					+ makeStringParam(account.getPromotion_code()) + "," + makeStringParam(account.getReferer_email())
					+ "," + makeStringParam(account.getStatus()) + "," + makeStringParam(today.toString()) + "," + // status_effective_start_date
					makeStringParam(today.toString()) + "," + // status_effective_end_date
					makeStringParam(today.toString()) + ");";

			int result = statement.executeUpdate(sqlStatement);
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			exceptionMsg = "Account Creation Failed: SQL error. Contact System Administrator. Detail Error:"
					+ e.getMessage();
			throw new UserException(exceptionMsg);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			exceptionMsg = "Account Creation Failed: System error. Contact System Administrator";
			throw new UserException(exceptionMsg);
		} finally {
			DataManager.close(statement);
			DataManager.close(con);
		}

		User newAccount;
		try {
			newAccount = getUserByName(account.getUserName());
			
		} catch (UserException e) {
			exceptionMsg = "CreateAccount Failed:" + e.getMessage();
			throw new UserException(exceptionMsg);
		}

		return newAccount;

	}

	public static void updatePassword(User account) throws UserException {
		String exceptionMsg = "";

		Connection con = null;
		Statement statement = null;
		try {
			con = DataManager.getConnection();
			statement = con.createStatement();

			String sqlStatement = "update user set password =" + makeStringParam(account.getPassword()) + " where id= "
					+ account.getUserId() + ";";

			
			int result = statement.executeUpdate(sqlStatement);
			if (result == 1) {

			} else {
				System.out.println("Insert Failed");
				exceptionMsg = "Account Password Update Failed. Contact System Administrator.";
				throw new UserException(exceptionMsg);
			}
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			exceptionMsg = "Account Password Update Failed: SQL error. Contact System Administrator. Detail Error:"
					+ e.getMessage();
			throw new UserException(exceptionMsg);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			exceptionMsg = "Account Password Update Failed: System error. Contact System Administrator";
			throw new UserException(exceptionMsg);
		} finally {
			DataManager.close(statement);
			DataManager.close(con);
		}

	}

	public static void activateAccountByDay(User user, int numberofDays) throws UserException {
		// update user data

		java.util.Date effective_end_date;
		if (user.getStatus_effective_end_date().before(getToday())) {

			// if the account has already expired, effective-start-date will
			// update to today, effective_end_date will update to
			effective_end_date = getToday();
			user.setStatus_effective_start_date(getToday());
		} else
			effective_end_date = user.getStatus_effective_end_date();

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(effective_end_date);
		calendar.add(GregorianCalendar.DATE, numberofDays);

		user.setStatus_effective_end_date(calendar.getTime());
		user.setStatus("active");
		update(user);
	}

	public static void activateAccount(User user, MembershipTerm term) throws UserException {
		// update user data

		java.util.Date effective_end_date;
		if (user.getStatus_effective_end_date().before(getToday())) {

			// if the account has already expired, effective-start-date will
			// update to today, effective_end_date will update to
			effective_end_date = getToday();
			user.setStatus_effective_start_date(getToday());
		} else
			effective_end_date = user.getStatus_effective_end_date();

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(effective_end_date);
		calendar.add(GregorianCalendar.MONTH, term.getMonths());

		user.setStatus_effective_end_date(calendar.getTime());
		user.setStatus("active");
		update(user);
		informUserActivation(user);
	}

	public static void activateAccount(User user, Date endDate) throws UserException {
		// set user active term from now through endDate

		java.util.Date effective_end_date;
		if (user.getStatus_effective_end_date().before(getToday())) {

			// if the account has already expired, effective-start-date will
			// update to today, effective_end_date will update to
			effective_end_date = getToday();
			user.setStatus_effective_start_date(getToday());
		} else
			effective_end_date = user.getStatus_effective_end_date();

		user.setStatus_effective_end_date(endDate);
		user.setStatus("active");
		update(user);
		informUserActivation(user);
	}

	public static void informUserActivation(User user) {
		String toEmail = user.getEmail();
		String subject = "[Math Worksheet Creator]Enrollment Confirmation";
		String message = "Thank you and welcome to Noetic Learning. You are now enrolled in 'Noetic Learning Math Worksheet Creator' program. Here is your login information\n\n";
		String copy_message = "";
		message = message + "User name:" + user.getUserName() + "\n\n";
		message = message + "Please keep this email for your future reference.\n\n";
		message = message
				+ "Your membership is valid for a year starting today.  We hope you enjoy the program.  Feel free to contact us at any time. We love to hear from you!\n\n";
		message = message + "--\n";
		message = message + "Regards,\n\n";
		message = message + "Noetic Learning\n\n";
		message = message + "http://www.noetic-learning.com\n\n";
		copy_message = copy_message + "The following email has been sent to " + toEmail + "\n\n";
		copy_message = copy_message + message;

		ResourceBundle resource = ResourceBundle.getBundle("mathdrill");
		String sender = resource.getString("email.noetic.from");
		String copyReceiver = resource.getString("email.noetic.admin");
		
	}

	public static void update(User account) throws UserException {
		String exceptionMsg = "";

		Connection con = null;
		Statement statement = null;
		try {
			con = DataManager.getConnection();
			statement = con.createStatement();
			String sqlStatement = "update user set email =" + makeStringParam(account.getEmail()) + ", status="
					+ makeStringParam(account.getStatus()) + ", phone=" + makeStringParam(account.getPhone())
					+ ", status_effective_start_date="
					+ makeStringParam(getSQLDate(account.getStatus_effective_start_date()).toString())
					+ ",status_effective_end_date="
					+ makeStringParam(getSQLDate(account.getStatus_effective_end_date()).toString()) + " where id= "
					+ account.getUserId() + ";";

			System.out.println(sqlStatement);
			
			int result = statement.executeUpdate(sqlStatement);
			if (result == 1) {

			} else {
				System.out.println("Insert Failed");
				exceptionMsg = "Account Update Failed. Contact System Administrator.";
				throw new UserException(exceptionMsg);
			}
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			exceptionMsg = "Account Update Failed: SQL error. Contact System Administrator. Detail Error:"
					+ e.getMessage();
			throw new UserException(exceptionMsg);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			exceptionMsg = "Account Update Failed: System error. Contact System Administrator";
			throw new UserException(exceptionMsg);
		} finally {
			DataManager.close(statement);
			DataManager.close(con);
		}

	}

	public static Assignment getUserAssignment(int userId) throws UserException {

		AssignmentDao dao = new AssignmentDao();
		Assignment assignment;
		try {
			assignment = dao.selectByUserId(userId);
		} catch (SQLException e) {
			
			throw new UserException(e.getMessage());
		}

		return assignment;

	}

	public static void saveWorksheet(User user, String worksheetData, String assignmentName) throws UserException {

		AssignmentDao dao = new AssignmentDao();
		Assignment assignmentOld = getUserAssignment(user.getUserId());
		try {
			if (assignmentOld == null) {
				dao.insert(user, worksheetData, assignmentName);
			} else {
				dao.update(user, worksheetData, assignmentName);
			}
		} catch (SQLException e) {
			
			throw new UserException(e.getMessage());
		}

	}

	public static void logUserActivity(int user_id, String sessionId) {
		String exceptionMsg = "";
		int result;
		if (sessionexisted(user_id, sessionId)) {
			System.out.println("session existed");
			updateUserActivity(user_id, sessionId);
		} else {
			Connection con = DataManager.getConnection();
			Statement statement = null;
			try {
				statement = con.createStatement();
				String sqlStatement = "insert into user_session_log (user_id,session_id,date, start_time, end_time) values ("
						+ user_id + "," + makeStringParam(sessionId) + "," + "curdate()," + "now(),now()" + ");";
				
				System.out.println(sqlStatement);
				result = statement.executeUpdate(sqlStatement);
			} catch (SQLException e) {

				System.out.println("SQLException:" + e.getMessage());
				e.printStackTrace();
				exceptionMsg = "LogUserActivity Failed: SQL error. Contact System Administrator";
				
			} catch (Exception e) {

				System.out.println("Exception:" + e.getMessage());
				e.printStackTrace();
				exceptionMsg = "LogUserActivity  Failed: System error. Contact System Administrator";
				
			} finally {
				DataManager.close(statement);
				DataManager.close(con);
			}

		}

	}

	public static void updateUserActivity(int user_id, String sessionId) {
		String exceptionMsg = "";
		Connection con = null;
		Statement statement = null;
		try {
			con = DataManager.getConnection();
			statement = con.createStatement();

			String sqlStatement = "update user_session_log set end_time= now() where user_id=" + user_id
					+ " and session_id=" + makeStringParam(sessionId) + ";";
			
			System.out.println(sqlStatement);
			int result = statement.executeUpdate(sqlStatement);
		} catch (SQLException e) {

			System.out.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			exceptionMsg = "updateUserActivity Failed: SQL error. Contact System Administrator";
			
		} catch (Exception e) {

			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			exceptionMsg = "updateUserActivity  Failed: System error. Contact System Administrator";
			
		} finally {
			DataManager.close(statement);
			DataManager.close(con);
		}

	}

	public static boolean sessionexisted(int user_id, String sessionId) {
		String exceptionMsg = "";
		boolean bReturn = false;
		Connection con = null;
		Statement statement = null;

		try {

			con = DataManager.getConnection();
			statement = con.createStatement();
			QueryBuilder query = new QueryBuilder("select * from user_session_log where user_id=? and session_id=?;");
			query.AddParameter("" + user_id);
			query.AddStringParameter(sessionId);
			String sqlStatement = query.getQueryString();
			
			ResultSet result = statement.executeQuery(sqlStatement);
			bReturn = result.first();
		} catch (SQLException e) {
			exceptionMsg = "UserManager.sessionexisted Failed: SQL error. Contact System Administrator";
			
		} catch (Exception e) {

			exceptionMsg = "UserManager.sessionexisted  Failed: System error. Contact System Administrator";
			
		} finally {
			DataManager.close(statement);
			DataManager.close(con);
		}

		return bReturn;

	}

	public static ArrayList getUserActivity(int userId) throws UserException {
		UserActivity userActivity = null;
		ArrayList arrayList = new ArrayList();
		String exceptionMsg = "";
		Connection con = null;
		Statement statement = null;

		try {
			con = DataManager.getConnection();
			statement = con.createStatement();
			QueryBuilder query = new QueryBuilder(
					"SELECT u.user_id, u.date, sum(TIME_TO_SEC(u.end_time)- TIME_TO_SEC(u.start_time)) length FROM user_session_log u where u.user_id=? and DATE_ADD(u.date, INTERVAL 30 DAY)>=curdate() group by u.user_id, u.date  order by u.date desc ");
			query.AddParameter("" + userId);
			String sqlStatement = query.getQueryString();
			
			ResultSet result = statement.executeQuery(sqlStatement);
			while (result.next()) {
				userActivity = new UserActivity();
				userActivity.setDate(getUtilDate(result.getDate("date")));
				userActivity.setLength(result.getInt("length"));
				arrayList.add(userActivity);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			exceptionMsg = "Error: getUserActivity failed: SQL error:" + e.getMessage()
					+ "  Contact System Administrator";
			
			throw new UserException(exceptionMsg);
		} catch (Exception e) {
			e.printStackTrace();
			exceptionMsg = "Error: getUserActivity failed: System error:" + e.getMessage()
					+ "  Contact System Administrator";
			
			throw new UserException(exceptionMsg);
		} finally {
			DataManager.close(statement);
			DataManager.close(con);
		}

		if (arrayList.size() <= 0)
			arrayList = null;
		return arrayList;

	}

	public static void main(String args[]) {

		java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
		User user = new User();
		user.setUserName("testing1");
		user.setEmail("testing@yahoo.com");
		user.setPassword("x");
		try {
			UserManager.create(user);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}

	}

}