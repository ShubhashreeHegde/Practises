import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frametest {

	public static void main(String[] args) {
//		HTML frames allow developers to present documents in multiple views, which may be
//		independent windows or subwindows. Multiple views offer developers a way to keep certain
//		information visible, while other views are scrolled or replaced. For example, within the same
//		window, one frame might display a static banner, the second a navigation menu, and the third
//		the main document that can be scrolled through or replaced by navigating in the second frame.
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\practise-selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		//finding number of frames in the application
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
//		driver.findElement(By.id("draggable")).click();
		WebElement source= driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		//drag from source and drop to destination
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		//we shopuld write it after comp;leting with frame to come out from frame.
		driver.switchTo().defaultContent();
		
		
		
	}
}
