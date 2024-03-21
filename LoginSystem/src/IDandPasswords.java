import java.util.HashMap;

public class IDandPasswords {

	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	 IDandPasswords(){
		logininfo.put("hakan", "1234");
		logininfo.put("tan", "123");
		logininfo.put("yasin", "12");
	}
	
	protected HashMap getLoginInfo(){
		return logininfo;
	}

}
