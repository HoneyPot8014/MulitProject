package utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcConnectionHelper {
	//Oracle jdbc Connect를, util패키지에 static으로 구현.

	public static Connection connection = null;	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("접속 성공");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl12c";
		System.out.println("로드 성공");
		connection = DriverManager.getConnection(url, "honeypot", "oracle");
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from schedule");
		System.out.println("상품번호 \t 상품명 \t 최저가 \t 최고가");
		while(resultSet.next()) {
			String day = resultSet.getString("day");
			int number = resultSet.getInt("time");
			System.out.println(day + number);
		}
	}
}
