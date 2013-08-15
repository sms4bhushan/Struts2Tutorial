package online.solution;

public class LoginAction implements com.opensymphony.xwork2.Action {

	@Override
	public String execute() throws Exception {

		return null;
	}

	public String loginUser() throws Exception {

		if (!getUsername().isEmpty() && !getPassword().isEmpty()) {
			if (getUsername().equalsIgnoreCase("admin")
					&& getPassword().equalsIgnoreCase("password")) {
				return SUCCESS;
			}
			else {
				return ERROR;
			}
		}
		else {
			return ERROR;
		}
	}

	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
