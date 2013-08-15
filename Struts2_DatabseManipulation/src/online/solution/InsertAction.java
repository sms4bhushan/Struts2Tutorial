package online.solution;

import java.sql.PreparedStatement;

import online.solution.database.DatabaseResource;

import com.opensymphony.xwork2.Action;

public class InsertAction implements Action {

	@Override
	public String execute() throws Exception {
		try {
			String query = "INSERT INTO tbl_employee (username,password,type) VALUES (?,?,?)";
			DatabaseResource.openConnection(query);
			System.out.println(employee.getUsername());
			PreparedStatement statement = DatabaseResource.getStatement();
			statement.setString(1, employee.getUsername());
			statement.setString(2, employee.getPassword());
			int type = 0;
			if (employee.getUserType().equalsIgnoreCase("admin")) {
				type = 1;
			}
			statement.setInt(3, type);
			statement.execute();
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return ERROR;
		}
		finally {
			DatabaseResource.closeConnection();
		}
		return SUCCESS;
	}

	private Employee employee = new Employee();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
