import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//handeling multiple window and invoking multiples windows are different
		//driver.switchTo().newWindow(WindowType.TAB); //opens new tab
		//Switching Window
		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handles=driver.getWindowHandles(); // will get the id of all the opened windows(parent and child). return type is set data structure

		Iterator<String> it=handles.iterator(); //it will iterate for each windows

		String parentWindowId = it.next(); //control will move to 1st index i.e parent ID

		String childWindow =it.next(); //control will move to next i.e child

		driver.switchTo().window(childWindow); // now will switch to the child window

		driver.get("https://rahulshettyacademy.com/"); // url will enter in the child window

		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText(); //with that css selector 24 will be selected. by using get(1) we can select first

		driver.switchTo().window(parentWindowId);

		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
		//driver.quit();  //quits all teh windows
		
			
		//		name.sendKeys(courseName);

		//Screenshot of webelement. thos is introduced in version 4
		WebElement name=driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);  
		File file=name.getScreenshotAs(OutputType.FILE); //common.io jar will convert file object to teh  physical file
		FileUtils.copyFile(file, new File("logo.png"));  //png and jpeg formats


		//GEt Height & Width of box - from version 4 we can do it

		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());



	}

}
