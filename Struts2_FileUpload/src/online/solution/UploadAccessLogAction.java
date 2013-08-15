package online.solution;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.Action;

public class UploadAccessLogAction implements Action {

	@Override
	public String execute() throws Exception {

		try {
			System.out.println("Src File name: " + myLog);
			System.out.println("File name: " + myLogFileName);

			File fileToCreate = new File(destPath, myLogFileName);
			FileUtils.copyFile(myLog, fileToCreate);
			return SUCCESS;
		}
		catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	// Must be follow this name convention.
	private File myLog;
	private String myLogFileName;
	private String myLogContentType;
	private final String destPath = "D:\\Bhushan 13";

	public File getMyLog() {
		return myLog;
	}

	public void setMyLog(File myLog) {
		this.myLog = myLog;
	}

	public String getMyLogContentType() {
		return myLogContentType;
	}

	public void setMyLogContentType(String myLogContentType) {
		this.myLogContentType = myLogContentType;
	}

	public String getMyLogFileName() {
		return myLogFileName;
	}

	public void setMyLogFileName(String myLogFileName) {
		this.myLogFileName = myLogFileName;
	}

	public String getDestPath() {
		return destPath;
	}

}
