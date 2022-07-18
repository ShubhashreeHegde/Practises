import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValuesDrive {

	public static void main(String[] args) throws IOException {
	
		//there is a class called Properties in java which will help to scan and extract the values of any .properties file. So we are giving the file name with that extension
		Properties prop=new Properties();
		
		//now we have to tell to our properties calss where exactly out file is present. for that we needto create file object for that 
		FileInputStream fis=new FileInputStream("D:\\Selenium\\CoreJava\\src\\Data.properties");
		
		//now fis has a knowledge where is the file. tell that to prop
		prop.load(fis);  //it will load meanse read
		
		prop.getProperty("browser");
		prop.getProperty("url");
		prop.setProperty("browser", "Firefox"); //now the chrome will change to Firefox
		//System.out.println(prop.getProperty("browser"));
		//System.out.println(prop.getProperty("url"));
		
		//now the browser is changed from chrome to firefox here, but not changed in properties file. So we need to write back to file. Fot that outstream 
		FileOutputStream fos=new FileOutputStream("D:\\Selenium\\CoreJava\\src\\Data.properties");
		prop.store(fos, null);  //it will store meanse write
		
		
		
		
	
	}

}
