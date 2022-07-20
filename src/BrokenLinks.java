import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// broken links meanse, it will not open and will show "Not found, 404". URL
		// tied up with that link is not opening
		//inspect > network > XHR/ALL > status code 200 meanse it is working like this we can check manually. If it is more than 400 meanse broken
		
		
		// Step 1 - IS to get all urls tied up to the links using Selenium
		// once we collect the URL, then there are some Java methods which will call URL's and gets you the status code
		// if status code >400 then that url is not working-> link which tied to url is broken

		String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("hreff"); // collected single soap UI link
		//String url=driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("hreff"); // collected single broken url  link

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));  // all links collcetd

		SoftAssert a = new SoftAssert();

		for (WebElement link : links)  //this is enhanced for loop

		{

			String url1 = link.getAttribute("href");  
			HttpURLConnection conn = (HttpURLConnection) new URL(url1).openConnection(); 			
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			
				
			//openConnection is a method exposed by URL class. Using openConnection method we can open connection and send url to the internet network and we can get teh response
			//url which we are sending as a connect need to send as an argument to the URL class.
			//HttpURLConnection is a return type of  openConnection method, and we are casting (HttpURLConnection)
			// there are different type of http method calls get,post,put, delete, head
			// sone now we have to tell what type of request method it is. We are making call using HEAD request mothod
			//finally we need to connect usning conn.connect();
			//what response we will get like 404,.. using getResponseCode method and storing in respCode

			// if we use this if condition, it will check the links continuously and if one broken url finds then it will fail
			//and it wont give the details of remaining links
//			if(respCode>400)
//			{
//				System.out.println("The link with Text" + link.getText() + " is broken with code" + respCode);
//				Assert.assertTrue(false);
//			}

			
			//if we dont want to stop in between we can use soft assertion
			//first create object for soft assertion - SoftAssert a = new SoftAssert();
			
			a.assertTrue(respCode < 400, "The link with Text" + link.getText() + " is broken with code" + respCode); //this is a soft assert because used object
			
			//Assert.assertTrue(respCode < 400, "The link with Text" + link.getText() + " is broken with code" + respCode); //this is a hard assert

		}

		a.assertAll();  //if we not write it, respcode will catch all failures but will not report

	}

	private static Object getReturnCode(WebElement link) {

//TODO Auto-generated method stub

		return null;

	}

}
