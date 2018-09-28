package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties pro;
	
	public ConfigReader() {
		try {
			File src = new File("./Configuration/Config.property");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is =="+e.getMessage());
		}
	}
	
	public String getChromePath() {
		String path = pro.getProperty("ChromeDriver");
		return path;
	}
}
