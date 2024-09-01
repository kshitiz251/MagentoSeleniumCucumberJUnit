package utilites;

import java.util.Date;

public class CommonUtils {
	
	public static final int IMPLICIT_WAIT_TIME = 20;
	public static final int PAGE_LOAD_TIMEOUT = 10;
	public static final int EXPLICIT_WAIT_BASIC_TIME = 20;

	public String getEmailWithTimeStamp() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":","_") + "@gmail.com";
		
	}
	
}
