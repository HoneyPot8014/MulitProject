package modelcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import utill.jdbcConnectionHelper;

public class Schedule implements SchedulingControl {

	public static String[][] schedule = new String[10][8];
	Connection connection = null;
	String day;
	int time;
	String subject;
	
	

	@Override
	public void memberInformation() {
	}

	@Override
	public void makeSchedule(String day, int time, String subject) {

		if (connection == null) {
			try {
				connection = jdbcConnectionHelper.getConnection();
				saveSchedule(day, time, subject);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 배열의 0,1 부터 월요일 9시로 기입하면 됌.
		// int time[] = {9, 10, 11, 12, 01, 02, 03, 04, 05, 06, 07};
		// for(int i = 0; i < schedule.length; i++) {
		// schedule[i][0] = String.format("%d", time[i]);
		// }
	}

	public void saveSchedule(String day, int time, String subject) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO SCHEDULE VALUES(?, ?, ?)");
			preparedStatement.setString(1, day);
			preparedStatement.setInt(2, time);
			preparedStatement.setString(3, subject);
			preparedStatement.executeUpdate();
			System.out.println("InsertQuery finished");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showSchedule() {
		try {
			if(connection == null) {
				connection = jdbcConnectionHelper.getConnection();
			}
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM SCHEDULE");
			while (resultSet.next()) {
				day = resultSet.getString("day");
				time = resultSet.getInt("time");
				subject = resultSet.getString("subject");
				System.out.println(day + time + subject);
				setResult();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setResult() {
		String[] days = {"월","화","수","목","금","토","일"};
		for(int i = 0; i < days.length; i++) {
			if(day.equals(days[i])) {
				schedule[time][i + 1] = subject;
			}
		}
	}
}
