package mathdrill.user;

import java.sql.SQLException;
import java.util.ArrayList;

import mathdrill.data.MembershipTermDao;

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
 * Company:
 * </p>
 * 
 * @author unascribed
 * @version 1.0
 */

public class MembershipTermManager extends BaseManager {

	static private ArrayList membershipTermList = null;

	static {
		try {
			init();
		} catch (Exception e) {
			
		}
	}

	public MembershipTermManager() {
	}

	static public ArrayList getMembershipTermList() throws UserException {

		init();
		return membershipTermList;
	}

	static public void init() throws UserException {
		if (membershipTermList != null && membershipTermList.size() > 0)
			return;

		MembershipTermDao dao = new MembershipTermDao();
		try {
			membershipTermList = (ArrayList) dao.getMembershipTermList();
		} catch (SQLException e) {
			
			throw new UserException(e.getMessage());
		}

	}

	static public ArrayList getMembershipTermListByPromotionCode(String promotionCode) {

		MembershipTermDao dao = new MembershipTermDao();
		ArrayList membershipTermList1 = null;
		try {
			membershipTermList1 = (ArrayList) dao.getMembershipTermListByPromotionCode(promotionCode);
		} catch (SQLException e) {
			
		}

		if (membershipTermList1 == null || membershipTermList1.size() < 1) {
			membershipTermList1 = membershipTermList;
		}
		return membershipTermList1;
	}

	static public MembershipTerm getMembershipTermById(int membershipTermId) {

		MembershipTermDao dao = new MembershipTermDao();
		MembershipTerm term = null;
		try {
			term = dao.getMembershipTermById(membershipTermId);
		} catch (SQLException e) {
			
		}

		return term;
	}

	static public MembershipTerm getMembershipTermByName(String name) {
		MembershipTermDao dao = new MembershipTermDao();
		MembershipTerm term = null;
		try {
			term = dao.getMembershipTermByName(name);
		} catch (SQLException e) {
			
		}

		return term;

	}

	public static void main(String[] args) {
		try {
			ArrayList list = MembershipTermManager.getMembershipTermList();
			for (int i = 0; i < list.size(); i++) {
				MembershipTerm term = (MembershipTerm) list.get(i);

				System.out.println(term.getName());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}