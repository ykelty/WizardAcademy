package mathdrill.user;

import java.sql.SQLException;

import mathdrill.data.SurveyDao;

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

public class SurveyManager extends BaseManager {

	public SurveyManager() {
	}

	public static void saveResult(String email, String question, String answer) {

		SurveyDao dao = new SurveyDao();
		try {
			dao.insert(email, question, answer);
		} catch (SQLException e) {
			
		}

	}

	public static void main(String args[]) {
		saveResult("", "Your profession", "teacher");
	}

}