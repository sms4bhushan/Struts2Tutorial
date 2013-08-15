package online.solution;

import com.opensymphony.xwork2.Action;

public class SimpleAction implements Action {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		if (password.equalsIgnoreCase("kumar")) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}

	}
}
