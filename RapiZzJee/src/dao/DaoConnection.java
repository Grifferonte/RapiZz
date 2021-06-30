package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnection {

	private static  String url_jdbc = "jdbc:mysql://127.0.0.1:3306/Rapizz?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private static  String login = "root";
	private static  String pwd = "Ft26@AlpS3";
	
	static Connection connexionBD() throws Exception {
		Connection conn;
		try  {
	    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection(url_jdbc, login, pwd);
		return conn;
	}	
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}