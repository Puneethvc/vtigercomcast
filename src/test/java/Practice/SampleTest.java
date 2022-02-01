package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SampleTest {

	public static void main(String[] args) throws IOException {

		
		FileInputStream f = new FileInputStream("./vtiger/vtiger.txt");
		Properties p = new Properties();
		p.load(f);
		
	String url = p.getProperty("url");
	String username = p.getProperty("username");
	String password = p.getProperty("password");
	String browser = p.getProperty("browser");
	
	FileInputStream file = new FileInputStream("./vtiger/vtiger.xlsx");
	Workbook wb = WorkbookFactory.create(file);
	Sheet sh = wb.getSheet("sheet1");
	Row row = sh.getRow(0);
	String org = row.getCell(1).getStringCellValue();
	 double org1 = sh.getRow(1).getCell(1).getNumericCellValue();
	
	
	
	WebDriver driver = null;
	if(browser.equals(browser))
	{
		driver=new ChromeDriver();
	}
	else 
		{
		driver = new FirefoxDriver();
		}
	
   
   driver.get(url);
   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   driver.findElement(By.name("user_name")).sendKeys(username);
   driver.findElement(By.name("user_password")).sendKeys(password);
   driver.findElement(By.id("submitButton")).click();
  
   driver.findElement(By.linkText("Organizations")).click();
   driver.findElement(By.xpath("//img[title='Create Organization...']")).click();
   driver.findElement(By.name("accountname")).sendKeys(org);
   driver.findElement(By.id("phone"));
   
   /* Step 6 : logout*/
   Actions act = new Actions(driver);
   act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
   driver.findElement(By.linkText("Sign Out")).click();
   driver.close();
   
   }

}
