package fr.eni.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.dal.Settings;

public class JdbcTools {

	private static String url;
	private static String driver;
	private static String login;
	private static String passw;
	
	
	static {
		
		url = Settings.getProperty("urldb");
		driver = Settings.getProperty("driverdb");
		login = Settings.getProperty("userdb");
		passw = Settings.getProperty("passdb");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Attention le driver n'a pas été trouvé");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, login, passw);
	}
	
}
