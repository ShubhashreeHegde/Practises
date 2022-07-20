import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// if there is selct tag for any drop down then that is a static drop down
		//dropdown with select tag
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown=new Select(staticDropdown); //dropdown object creation for select class
		
		//1.selectByIndex
		dropdown.selectByIndex(3);
		dropdown.getFirstSelectedOption().getText();    //getFirstSelectedOption - is returs the webelement, get will gets the text of that webelement
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//2.selectByVisibleText
		//if we want to select based on the visible text
		dropdown.selectByVisibleText("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//3.select by value
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		

	}

}
