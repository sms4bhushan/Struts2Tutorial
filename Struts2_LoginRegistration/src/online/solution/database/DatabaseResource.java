package online.solution.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseResource {

	private static String dbName;
	private static String dbUsername;
	private static String dbPassword;

	static {
		System.out.println("static block called..");
		Properties prop = new Properties();
		// prop.load(new FileInputStream("database.properties"));
		try {
			prop.load(DatabaseResource.class.getClassLoader()
					.getResourceAsStream("database.properties"));
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}
		dbName = prop.getProperty("database");
		dbUsername = prop.getProperty("dbUsername");
		dbPassword = prop.getProperty("dbPassword");
		/*
		System.out.println("DatabaseName -> "
				+ prop.getProperty("database"));
		System.out.println(prop.getProperty("dbUsername"));
		System.out.println(prop.getProperty("dbPassword"));

		}

		public DatabaseResource() {
		System.out.println("Constructor calles..");
		Properties prop = new Properties();
		try {
		// prop.load(new FileInputStream("database.properties"));
		prop.load(getClass().getClassLoader().getResourceAsStream(
				"database.properties"));
		dbName = prop.getProperty("database");
		dbUsername = prop.getProperty("dbUsername");
		dbPassword = prop.getProperty("dbPassword");
		/*
		System.out.println("DatabaseName -> "
				+ prop.getProperty("database"));
		System.out.println(prop.getProperty("dbUsername"));
		System.out.println(prop.getProperty("dbPassword"));
		*/

	}

	private static Connection connection = null;
	private static PreparedStatement statement = null;

	public static Connection getConnection() {
		return connection;
	}

	public static PreparedStatement getStatement() {
		return statement;
	}

	public static void setStatement(PreparedStatement statement) {
		DatabaseResource.statement = statement;
	}

	public static void setConnection(Connection connection) {
		DatabaseResource.connection = connection;
	}

	public final static void openConnection(String query) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + dbName, dbUsername,
					dbPassword);
			statement = connection.prepareStatement(query);

		}
		catch (Exception e) {
			System.out.println("Exception -> " + e);
			closeConnection();
		}
		finally {

		}
	}

	public static final void closeConnection() throws SQLException {
		try {
			// System.out.println("Inside close connection -> ");

			if (!statement.isClosed()) {
				// System.out.println("Inside Statement close connection -> ");
				statement.close();
			}

			if (!connection.isClosed()) {
				connection.close();
			}

		}
		catch (Exception e) {
			System.out.println("closeConnection -> " + e);
		}
		finally {

		}
	}
}
