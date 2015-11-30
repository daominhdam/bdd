package axonactive.webapp.until;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by thuynguyen on 7/4/2015.
 */
public class TestUtils {

	public static Properties readUserConfigs(InputStream input) {
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop;
	}

	public static void fnHighlightMe(WebDriver driver,WebElement element) throws InterruptedException{
		//Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for (int iCnt = 0; iCnt < 3; iCnt++) {
			//Execute javascript
			js.executeScript("arguments[0].style.border='4px groove green'", element);
			Thread.sleep(1000);
			js.executeScript("arguments[0].style.border=''", element);
		}




	}


}
