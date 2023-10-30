package Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Autoprojectpage {
	WebDriver driver;
	
	By logo=By.xpath("//*[@id=\"homeHead\"]/img");
	By jobs=By.xpath("//*[@id=\"jobTab\"]");
	By jobcategory=By.xpath("//*[@id=\"jobsByCategory2\"]/a");
	By services=By.xpath("//*[@id=\"ngHeader\"]/div/nav/ul/li[3]/a");
	By resumemaker=By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/div/ul/li[3]");
	By login=By.xpath("//*[@id=\"ngHeader\"]/div/nav/ul/li[5]");
	By usname=By.xpath("//*[@id=\"loginModalLoginEmail\"]");
	By pwd=By.xpath("//*[@id=\"loginPassword\"]");
	By log=By.id("loginModalLoginSubmit");
	By cv=By.xpath("//*[@id=\"formNavbar\"]/div/button[10]");
	By browse=By.xpath("//*[@id=\"cv\"]/section/label");
	By viewprofile=By.xpath("//*[@id=\"ngHeader\"]/div/nav/ul/li[8]/p/span[2]");
	By logout=By.xpath("//*[@id=\"logoutLink\"]");
	

	
	public Autoprojectpage(WebDriver driver)
	{
     this.driver=driver;
	}
	
	public void titleverification()
	{
		String title=driver.getTitle();
		String t="naukrigulf";
		if(title.equals(t))
		{
			System.out.println("title same");	
			
		}
		else
		{
			System.out.println("title diffrent");
		}
	}
	
	public void contentverification()
	{
		String contnt=driver.getPageSource();
		if(contnt.contains("naukrigulf"))
				{
			System.out.println("this page contains the word naukrigulf");
			
		}
		else
		{
			System.out.println("this page doesnot containsthe word naukrigulf");
		}
		
	}
	
	public void logodisplay()
	{
		WebElement va=driver.findElement(logo);
				boolean bo=va.isDisplayed();
		if(bo)
		{
			System.out.println("logo displayed");
		}
		else
		{
			System.out.println("logo is not displayed");
		}
	}
	
	public void screenshot() throws IOException
	{
		File src=(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE));
		FileHandler.copy(src, new File("C:\\\\Users\\\\Amritha P\\\\Desktop\\\\screenshot//sshot.png"));
	}
	
	public void mouseover()
	{
		Actions act=new Actions(driver);
		WebElement am=driver.findElement(jobs);
		act.moveToElement(am);
		act.perform();
		driver.findElement(jobcategory).click();
	}
	
	public void handlewindow()
	{
		String parentWindow=driver.getWindowHandle();
		driver.findElement(services).click();
		
		Set<String>childwindow=driver.getWindowHandles();
		for(String handle:childwindow)
		{
			if(!handle.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(handle);
				driver.findElement(resumemaker).click();
				
				
	}
		}
	driver.switchTo().window(parentWindow);
	driver.navigate().back();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void scrolldown()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,500)", "");
		
	
	}
	

	
	public void login() throws IOException
	{
		driver.findElement(login).click();
		File f=new File("C:\\Users\\Amritha P\\Downloads\\Book 12.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			String Username=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(Username);
			String Password=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(Password);
			
			driver.findElement(usname).clear();
			driver.findElement(usname).sendKeys(Username);
			driver.findElement(pwd).clear();
			driver.findElement(pwd).sendKeys(Password);
			driver.findElement(log).click();
			
			
	}
	
	}
	public void upload() throws Exception
	{
		driver.findElement(cv).click();
		driver.findElement(browse).click();
		fileUpload("C:\\Users\\Amritha P\\Downloads\\TASK-1.pdf");
		}
	
	public void fileUpload(String p) throws Exception
	{
	StringSelection strSelection=new StringSelection(p);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection,null);
	Robot robot=new Robot();
	robot.delay(3000);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	
	}
}
	
	
	
	
	
	
	

	

