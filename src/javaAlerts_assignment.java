import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
public class javaAlerts_assignment {

	public static void main(String[] args) {
		
		String text = "Rahul";

		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//we cannot handle alert usinhg HTML because thses are javascript
		driver.findElement(By.id("name")).sendKeys(text);

		//one alert = OK click
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();

		System.out.println(driver.switchTo().alert().getText());  //grabing text on the alert

		driver.switchTo().alert().accept();//context will switch from driver to alert and it will accept
		//selenium will find the positivity side and OK/Yes is clicked  when use accept

		//second alerts = OK or Cancel click
		driver.findElement(By.id("confirmbtn")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().dismiss(); //selenium will find the negativity side and close the alert when use dismiss
		
		//window authenticaton pop ups cannot handled with alert ethods. We can handle those with AutoIt

	}

}