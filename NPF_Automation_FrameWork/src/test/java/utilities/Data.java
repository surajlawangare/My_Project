package utilities;

import org.testng.annotations.DataProvider;

public class Data {


	@DataProvider (name="name") 
	public String[][] getDataname() {
			
		   String[][] data = {
			                  {"Test123"},
			                  {"Test@#$%"},
			                  {""}
			                   };
			
	return data;
	}
	
	
	@DataProvider (name="email") 
	public String[][] getDataemail() {
			
		   String[][] data = {
			                  {"Test123"},
			                  {"@&^%#$%"},
			                  {"test@.com"},
			                  {"Test@ytai78l.com"},
			                  {"7654324566"},
			                  {""}
			                   };
			
	return data;
	}
	
	
	@DataProvider (name="countrycode") 
	public String[][] getDatacountrycode() {
			
		   String[][] data = {
			                  {"$('#ul_dial_codeMobile li[data-value=\"+244\"]').click();\r\n" + "", "7556"},
			                  {"$('#ul_dial_codeMobile li[data-value=\"+91\"]').click();\r\n" + "", "7667"},
			                  {"$('#ul_dial_codeMobile li[data-value=\"+91\"]').click();\r\n" + "", ""}
			                   };
			
	return data;
	}
	
	
	@DataProvider (name="Login") 
	public String[][] getDatalogin() {
			
		   String[][] data = {{"suraj.lavangare@nopaperforms.com","abc@1"},
			                  {"Test","abc@123"},
			                  {"Test","Test123"},
			                  {"suraj.lavangare@nopaperforms.com",""},
			                  {"","abc@123"},
			                  {"",""}
			                   };
			
	return data;
	}
	
	
	@DataProvider (name="verifymail") 
	public String[][] getDataverifymail() {
			
		   String[][] data = {{"suraj.com"},
			                  {"Test123"},
			                  {""}
			                   };
			
	return data;
	}
	
	
	@DataProvider (name="forgotmail") 
	public String[][] getDataforgotmail() {
			
		   String[][] data = {{"mhjgf@gmail.com"},
			                  {"Test123"},
			                  {""}
			                   };
			
	return data;
	}
	
	
	@DataProvider (name="captcha") 
	public String[][] getDatacaptcha() {
			
		   String[][] data = {{""},
			                  {"1234"}
			                   };
			
	return data;
	}
}
