package online.solution;

import com.opensymphony.xwork2.Action;

public class RegisterAction implements Action {

	@Override
	public String execute() throws Exception {

		// System.out.println("Insideemployee action ");
		int flag = Employee.insertEmployee(this);

		if (flag > 0) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}

	}

	private String username;
	private String password;
	private String userType;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
