package stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
public class ZooplaStep {
	Properties prop=null;
	
	public void openURL() {
		WebDriver driver = null;
		try {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get(prop.getProperty("com.zoopla.url"));
		driver.manage().window().maximize();
		}catch(Exception e) {
			System.out.println("Exception: " + e);
		}  finally{
		//	driver.quit();
		}
	}
	public void getPropValues() throws IOException {
		InputStream inputStream = null; 
		try {
		    prop = new Properties();
			String propFileName = "zoopla.properties";
 
		    inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}
}
