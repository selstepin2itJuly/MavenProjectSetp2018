package testNGPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class TestNGTwo {
  @Test(groups= {"sanity"})
  public void TestOne() {
	  System.out.println("TestOne");
  }
  @Test(groups= {"Regression"})
  public void TestTwo() {
	  System.out.println("TestTwo");
  }
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	  System.out.println("After Method");
  }

  @AfterSuite(alwaysRun=true)
  public void afterSuite() {
	  System.out.println("After Suite");
  }
  @BeforeTest(alwaysRun=true)
  public void beforeTest() {
	  System.out.println("Before Test");
  }

}
