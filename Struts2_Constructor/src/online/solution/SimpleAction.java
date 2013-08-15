package online.solution;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class SimpleAction implements Action, Preparable {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	@Override
	public void prepare() {
		System.out.println("Prepare data automaticall caleed...");
	}*/

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	int i = 1;

	@Override
	public void prepare() throws Exception {
		System.out.println("Prepare() automaticall caleed... -> " + i);
		i++;
	}

	public void prepareData() throws Exception {
		// It wiil be not called...
		System.out.println("Prepare data automaticall caleed... -> " + i);
	}

	public void prepareExecute() throws Exception {
		System.out.println("HelloWorldAction prepareExecute() is called.");
	}

}
