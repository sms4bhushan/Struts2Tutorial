package online.solution;

import com.opensymphony.xwork2.Action;

public class MyAction implements Action {

	/**
	 * 
	 */

	@Override
	public String execute() throws Exception {
		System.out.println("In Action Class.---------> (y)");
		return SUCCESS;
	}
}
