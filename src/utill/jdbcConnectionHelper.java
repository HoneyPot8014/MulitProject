package utill;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcConnectionHelper {
	//Oracle jdbc Connect를, util패키지에 static으로 구현.

	public static Connection connection = null;	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl12c";
		connection = DriverManager.getConnection(url, "honeypot", "oracle");
		return connection;
	}
}
