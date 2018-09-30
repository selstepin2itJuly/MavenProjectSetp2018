package testNGPackage;

import org.testng.annotations.Test;

import config.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class TestNGOne {
	
	static WebDriver driver;
	static TestBase tb;
  @Parameters({"email", "pass"})
  @Test(priority=1,description="Login Feature", enabled=true,groups= {"sanity"})
  public void loginFeature(String email, String pass) throws InterruptedException {
	  System.out.println("TestOne");
	  driver.findElement(By.id("email")).sendKeys(email);
	  driver.findElement(By.id("pass")).sendKeys(pass);
	  driver.findElement(By.id("loginbutton")).click();
	  String actual = driver.getTitle();
	  assertEquals("Log into Facebook | Facebook", actual);
	  Thread.sleep(5000);
  }
  
  @Test(priority=3, description="Forgot Link", groups= {"Regression"})
  public void forgotLink() throws InterruptedException {
	  System.out.println("TestTwo");
	  Thread.sleep(4000);
	  driver.findElement(By.partialLinkText("Forgot")).click();
	  assertFalse(true);
  }
  
  @Test(priority=2, description="Privacy",enabled=true, groups= {"sanity"})
  public void privacyPolicy() throws InterruptedException {
	  System.out.println("TestTwo");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//li/*[text()='Privacy']")).click();
	  String str=driver.findElement(By.xpath("//div/h2[text()='Data Policy']")).getText();
	  System.out.println(str);
	  assertTrue(str.contains("Data Policy"));
  }
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() {
	  System.out.println("Before Method");
	  tb = new TestBase();
	  driver =  tb.init("http://www.facebook.com", "chrome");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	  System.out.println("After Method");
	  driver.quit();
  }

  /*@BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }*/

  
 
  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  
}
