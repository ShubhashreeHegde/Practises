import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;


public class Miscelleanous {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();  //deleting all the cookies
		driver.manage().deleteCookieNamed("sessionKey"); //will delete only the given cookies. If we use this the session/secure login will logged out
		driver.manage().addCookie(null); //we can add the cookies
	
		//login, delete the cookie using session cookie, click on any link, login page- verify login url-- like this we can test session expiry
		
		driver.get("http://google.com");
		
		
		//taking screenshot		
		//casting driver object to the TakesScreenshot method. Now dribver is ready to take screenshot.
		//OutputType.FILE - get the screenshoyt as File. That we are storing in src
		// FileUtils is a method to copy the file from src to local drive
		File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\rahul\\screenshot.png"));
	
		//import org.apache.commons.io.FileUtils; - this package wa not there. So went to https://commons.apache.org/proper/commons-io/download_io.cgi adn downloaded "commons-io-2.11.0" jar
		//went to project in eclipse - right click > properties > java build path > add external jars > take all jars > add
	}

}
