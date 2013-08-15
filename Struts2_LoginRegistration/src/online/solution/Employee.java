package online.solution;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import online.solution.database.DatabaseResource;

public class Employee {

	public static int insertEmployee(RegisterAction action) throws SQLException {
		try {

			String query = "INSERT INTO tbl_employee (username,password,type) VALUES (?,?,?)";
			DatabaseResource.openConnection(query);

			PreparedStatement statement = DatabaseResource.getStatement();
			statement.setString(1, action.getUsername());
			statement.setString(2, action.getPassword());
			int type = 0;
			if (action.getUserType().equalsIgnoreCase("admin")) {
				type = 1;
			}
			statement.setInt(3, type);
			return statement.executeUpdate();
		}
		catch (Exception exception) {
			System.out.println("insertEmployee -> " + exception);
			return 0;
		}
		finally {
			DatabaseResource.closeConnection();
		}

	}

	public static int loginEmployee(LoginAction action) throws SQLException {
		try {

			String query = "SELECT username,password FROM tbl_employee WHERE username = ? and password = ? and type=?";
			DatabaseResource.openConnection(query);

			PreparedStatement statement = DatabaseResource.getStatement();
			statement.setString(1, action.getUsername());
			statement.setString(2, action.getPassword());

			int type = 0;
			if (action.getUserType().equalsIgnoreCase("admin")) {
				type = 1;
			}
			statement.setInt(3, type);
			ResultSet user = statement.executeQuery();
			if (user.first()) {
				return 1;
			}
			else {
				return 0;
			}
		}
		catch (Exception exception) {
			System.out.println("insertEmployee -> " + exception);
			return 0;
		}
		finally {
			DatabaseResource.closeConnection();
		}

	}
}
