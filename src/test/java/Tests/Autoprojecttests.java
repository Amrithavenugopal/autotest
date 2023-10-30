package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Autoprojectpage;

public class Autoprojecttests {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver =new ChromeDriver();
	}

	@BeforeMethod
	public void url()
	{
		driver.get("https://www.naukrigulf.com/");
	}
	
	
	@Test
	public void test() throws Exception
	{
		Autoprojectpage obj=new Autoprojectpage(driver);
		driver.manage().window().maximize();
		obj.titleverification();
		obj.contentverification();
		obj.logodisplay();
		obj.screenshot();
		obj.mouseover();
		obj.handlewindow();
		obj.scrolldown();
		obj.login();
		obj.upload();
	}
}
