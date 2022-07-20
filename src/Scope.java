import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://qaclickacademy.com/practice.php");

		// 1. Give me the count of links on the page.
		// link will have a tag 'a'
		System.out.println(driver.findElements(By.tagName("a")).size());

		// 2. Count of footer section-
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));// selecting entire footer section (Limiting webdriver scope)
		// footerdriver plys the role like main driver
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// count of column - from the footerdriver create again subdriver(columndriver)
		// when we try to create another driver object should not use findelements,
		// should use findelement
		WebElement coloumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());

		// 4- click on each link in the coloumn and check if the pages are opening
		// i=0 not given because that is a heading part. So we are going only sub links
		// as per requirements
		for (int i = 1; i < coloumndriver.findElements(By.tagName("a")).size(); i++) {

			// we can use navigate back to come back to the main from the new window after
			// clicking on the each link but it is not the optimized way of doing it. 
			// we can also click all the links by doing cntrl+click to check all the links are working or not.
			//This thing we can use here
			// we should use chord to click many keys

			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			//clickonlinkTab is a keyboard event, so we need to use sendkeys method
			Thread.sleep(5000L);

		} // opens all the tabs
		
		//switch to all the chi;d windows and grab the title and print it
		Set<String> abc = driver.getWindowHandles();// all windows (4)
		Iterator<String> it = abc.iterator(); //iterator will use to move to eacjh windows
		
		while (it.hasNext()) {   // currenntly 'it' has 0 index and main window. First it will check whether 0th index is present and another window is there or not,  then it will go inside the loop
								// finally control will check whether next window is there or not. There is no next index so loop will exitx`
			driver.switchTo().window(it.next());  //it will move to 1st index
			System.out.println(driver.getTitle());  //prints the 1st windiw title

		}
	}

}
