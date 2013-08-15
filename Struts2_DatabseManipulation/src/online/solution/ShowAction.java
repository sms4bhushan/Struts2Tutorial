package online.solution;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ListIterator;

import online.solution.database.DatabaseResource;

import com.opensymphony.xwork2.Action;

public class ShowAction implements Action {

	@Override
	public String execute() throws Exception {
		try {
			String query = "SELECT username,password FROM tbl_employee";
			ResultSet record = DatabaseResource.selectQuery(query);

			Employee employee;

			while (record.next()) {
				employee = new Employee();
				employee.setUsername(record.getString("username"));
				employee.setPassword(record.getString("password"));
				list.add(employee);
			}
			ListIterator itr = list.listIterator();
			employee = new Employee();
			while (itr.hasNext()) {
				employee = (Employee) itr.next();
				System.out.println(employee.getUsername());
				System.out.println(employee.getPassword());
			}
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

	private ArrayList<Employee> list = new ArrayList<Employee>();

	public ArrayList<Employee> getList() {
		return list;
	}

	public void setList(ArrayList<Employee> list) {
		this.list = list;
	}
}
