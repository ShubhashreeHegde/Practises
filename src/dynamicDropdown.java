import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//parent child relationship xpath for the above - give first parent xpath then one space and write child xpath
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value=\"BLR\"]")).click();
				
		Thread.sleep(2000);
		
		//    //a[@value='MAA'] - in this xpath 2 matching nodes will found. So we can write as (//a[@value='MAA'])[2]
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]"));
		//parent child relationship xpath for the above
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']")).click();
		
		//selecting autopopped calendar date - Current date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
	
	}

}
