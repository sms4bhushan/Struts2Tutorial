package online.solution;

public class LoginAction implements com.opensymphony.xwork2.Action {

	@Override
	public String execute() throws Exception {
		/*
		if (!getUsername().isEmpty() && !getPassword().isEmpty()) {
			if (getUsername().equalsIgnoreCase("admin")
					&& getPassword().equalsIgnoreCase("admin")) {
				return SUCCESS;
			}
			else {
				return ERROR;
			}
		}
		else {
			return ERROR;
		}
		*/
		return SUCCESS;
	}

}
