package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Readpropertyfiles {


	public static void main(String[] args) throws IOException {
		
		FileReader filereeder =new FileReader("C:\\Users\\User\\eclipse-workspace\\NPF_Automation_FrameWork\\src\\test\\resources\\configfiles\\config1.properties");
		
		 Properties p= new Properties();
		 
		 p.load(filereeder);
		 
		 System.out.println(p.getProperty("browser"));
		 System.out.println(p.getProperty("testurl"));
		 
	}
}
