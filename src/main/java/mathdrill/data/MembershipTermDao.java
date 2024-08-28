package mathdrill.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mathdrill.user.MembershipTerm;

public class MembershipTermDao extends DataManager {

	public List<MembershipTerm> getMembershipTermList() throws SQLException {
		List<MembershipTerm> membershipTermList = new ArrayList<MembershipTerm>();
		String query = "Select * from membership_term where promotioncode='default'";
		try (Connection con = DataManager.getConnection(); PreparedStatement statement = con.prepareStatement(query)) {
			
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				MembershipTerm p = new MembershipTerm();
				p.setId(result.getInt("id"));
				p.setName(result.getString("name"));
				p.setMonths(result.getInt("months"));
				p.setPromotioncode(result.getString("promotioncode"));
				p.setPrice(result.getString("price"));
				membershipTermList.add(p);
			}
		}

		return membershipTermList;
	}

	public List<MembershipTerm> getMembershipTermListByPromotionCode(String promotionCode) throws SQLException {
		List<MembershipTerm> membershipTermList = new ArrayList<MembershipTerm>();
		String query = "Select * from membership_term where promotioncode=?";
		try (Connection con = DataManager.getConnection(); PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, promotionCode);
			
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				MembershipTerm p = new MembershipTerm();
				p.setId(result.getInt("id"));
				p.setName(result.getString("name"));
				p.setMonths(result.getInt("months"));
				p.setPromotioncode(result.getString("promotioncode"));
				p.setPrice(result.getString("price"));
				membershipTermList.add(p);
			}
		}

		return membershipTermList;
	}

	/**
	 * 
	 * @param membershipTermId
	 * @return null if no membership term found for membershipTermId
	 * @throws SQLException
	 */
	public MembershipTerm getMembershipTermById(int membershipTermId) throws SQLException {

		MembershipTerm p = null;
		String query = "Select * from membership_term where id=?";
		try (Connection con = DataManager.getConnection(); PreparedStatement statement = con.prepareStatement(query)) {
			statement.setInt(1, membershipTermId);
			
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				p = new MembershipTerm();
				p.setId(result.getInt("id"));
				p.setName(result.getString("name"));
				p.setMonths(result.getInt("months"));
				p.setPromotioncode(result.getString("promotioncode"));
				p.setPrice(result.getString("price"));

			}
		}

		return p;
	}

	public MembershipTerm getMembershipTermByName(String name) throws SQLException {
		MembershipTerm p = null;

		String query = "Select * from membership_term where name=?";
		try (Connection con = DataManager.getConnection(); PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				p = new MembershipTerm();
				p.setId(result.getInt("id"));
				p.setName(result.getString("name"));
				p.setMonths(result.getInt("months"));
				p.setPromotioncode(result.getString("promotioncode"));
				p.setPrice(result.getString("price"));

			}
		}

		return p;
	}

}
