import java.util.HashMap;

public class fileUpload {

	public static void main(String[] args) {
		
		//we can get the path of teh project  System.getProperty("user dir")
		String downloadPath=System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver.exe");
		
		//these 3 lines of codes should be added when we are using chromePrefs
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		
		//We are telling browser to download all the downloads in the provided path, not in the download folder
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);  //here prefs meanse preferences and it is one of teh object/key

		WebDriver driver=new ChromeDriver(options);
		driver.get("https://altoconvertpdftojpg.com/");
		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();
		Thread.sleep(3000);
				//we can access exe using java , so in runtime we can access
		Runtime.getRuntime().exec("C:\\Users\\rahul\\Documents\\check\\fileupload.exe");
		
		
		
		
		
		//Now how to download uploaded file
		//wait for sometime to upload file so using explicit waits
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));
		driver.findElement(By.cssSelector("button[class*='medium']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
		driver.findElement(By.linkText("Download Now")).click();
		Thread.sleep(5000);
		
		//create the object for teh file
		File f=new File(downloadPath+"/converted.zip");

		if(f.exists())   //it will check whether the path is existsy

		{

		Assert.assertTrue(f.exists());

		if(f.delete())

		System.out.println("file deleted");

		}

		}



	}


