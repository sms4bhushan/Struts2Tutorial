package online.solution.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseResource {

	private static final String dbName = "newdb";
	private static String dbUsername = "root";
	private static String dbPassword = "root";

	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static Statement simpleStatement = null;

	public static Statement getSimpleStatement() {
		return simpleStatement;
	}

	public static void setSimpleStatement(Statement simpleStatement) {
		DatabaseResource.simpleStatement = simpleStatement;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static PreparedStatement getStatement() {
		return preparedStatement;
	}

	public static void setStatement(PreparedStatement statement) {
		DatabaseResource.preparedStatement = statement;
	}

	public static void setConnection(Connection connection) {
		DatabaseResource.connection = connection;
	}

	public final static ResultSet selectQuery(String query) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + dbName, dbUsername,
					dbPassword);

			simpleStatement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			return simpleStatement.executeQuery(query);
			// connection.commit();
		}
		catch (Exception e) {
			System.out.println("Exception -> " + e);
			e.printStackTrace(System.out);
			// closeConnection();// It must be here or commented..
		}
		finally {

		}
		return null;
	}

	public final static void openConnection(String query) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + dbName, dbUsername,
					dbPassword);
			preparedStatement = connection.prepareStatement(query);
			// connection.commit();
		}
		catch (Exception e) {
			System.out.println("Exception -> " + e);
			// closeConnection();//It must be here or commented..
		}
		finally {

		}
	}

	public static final void closeConnection() throws SQLException {
		try {
			// System.out.println("Inside close connection -> ");

			if (!preparedStatement.isClosed()) {
				// System.out.println("Inside Statement close connection -> ");
				preparedStatement.close();
			}

			if (!simpleStatement.isClosed()) {
				// System.out.println("Inside Statement close connection -> ");
				simpleStatement.close();
			}

			if (!connection.isClosed()) {
				connection.close();
			}

		}
		catch (Exception e) {
			System.out.println("closeConnection -> " + e);
			e.printStackTrace(System.out);
		}
		finally {

		}
	}
}
