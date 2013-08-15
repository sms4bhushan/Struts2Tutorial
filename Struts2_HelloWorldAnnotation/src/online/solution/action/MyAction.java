package online.solution.action;

//Package name must contain prefix ".action"
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/*
 * @Results({ @Result(name = "success", location =
 * "helloWorld.jsp",type="TilesResult.class"),
 * 
 * @Result(name = "error", location = "error.jsp",type="TilesResult.class") })
 */

/*
 @WebListener("ServletContextListener")
 @Namespace("/")
 @Action(value = "MyActionUrl", results = {
 @Result(name = "SUCCESS", location = "helloWorld.jsp"),
 @Result(name = "error", location = "error.jsp") })
 */

public class MyAction {// No need to extends ActionSupport

	// filter in web.xml
	@Action(value = "/welcome", results = {
			@Result(name = "success", location = "/page/helloWorld.jsp"),
			@Result(name = "error", location = "/page/error.jsp")
	})
	public String execute() throws Exception {
		System.out.println("In MyAction Class.---------> (y)");
		return "success";
	}
}