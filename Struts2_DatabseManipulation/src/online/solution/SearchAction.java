package online.solution;

import java.sql.ResultSet;

import online.solution.database.DatabaseResource;

import com.opensymphony.xwork2.Action;

public class SearchAction implements Action {

	@Override
	public String execute() throws Exception {
		try {
			String query = "SELECT username,password FROM tbl_employee";
			ResultSet record = DatabaseResource.selectQuery(query);

			/*
			while (record.next()) {
				employee.setUsername(record.getString("username"));
				employee.setUsername(record.getString("password"));
			}*/
			record.first();
			employee.setUsername(record.getString("username"));
			employee.setPassword(record.getString("password"));

		}
		catch (Exception exception) {
			exception.printStackTrace();
			return ERROR;
		}
		finally {
			// DatabaseResource.closeConnection();
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
