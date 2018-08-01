package modelcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utill.jdbcConnectionHelper;

public class UserModelControl {
	
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	String selectedId;
	String selectedName;
	String selectedPassword;
	String selectedSchool;
	String selectedMajor;
	String selectedSnum;
	
	
	public UserModelControl() {
		if(connection == null) {
			try {
				connection = jdbcConnectionHelper.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//DB select query
	public void select(String id, String password) throws SQLException {
		if (statement == null) {
			statement = connection.createStatement();
		}
		ResultSet querySelect = statement.executeQuery("SELECT ID,PASSWORD FROM MEMBERSHIP WHERE" + id);
		while (querySelect.next()) {
			selectedId = querySelect.getString("id");
//			selectedName = querySelect.getString("name");
			selectedPassword = querySelect.getString("password");
//			selectedSchool = querySelect.getString("school");
//			selectedMajor = querySelect.getString("major");
//			selectedSnum = querySelect.getString("snum");
		}
	}
	
	public void insert(String id, String name, String password, String school, String major, String snum) throws SQLException {
		preparedStatement = connection.prepareStatement("INSERT INTO MEMBERSHIP VALUES(?, ?, ?, ?)");
		preparedStatement.setString(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, password);
		preparedStatement.setString(4, school);
		preparedStatement.setString(5, major);
		preparedStatement.setString(6, snum);
		preparedStatement.executeUpdate();
		System.out.println("쿼리 완료");
	}
	
	public void update(String column, int condition) throws SQLException {
		preparedStatement = connection.prepareStatement("update gift set gname = ? where g_end < ?");
		preparedStatement.setString(1, column);
		preparedStatement.setInt(2, condition);
		preparedStatement.executeUpdate();
		System.out.println("쿼리 완료");
	}
	
	public void delete(int giftNumber) throws Exception {
		preparedStatement = connection.prepareStatement("DELETE FROM GIFT WHERE gno = ?");
		preparedStatement.setInt(1, giftNumber);
		preparedStatement.executeUpdate();

		System.out.println("쿼리 완료	");
	}
	

}
