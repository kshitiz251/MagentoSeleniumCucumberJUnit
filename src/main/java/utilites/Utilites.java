package utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Utilites {

	public String fileReader(String element) {
		FileInputStream fis = null;
		Properties prop = new Properties();
		
		try {
			File file = new File(System.getProperty("user.dir") + "\\src\\test\\resource\\config\\config.properties");
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(element);
		
		
	}
}
