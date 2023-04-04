package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.HomePage;
import pompages.SeleniumTraningPage;
import pompages.SkillraryDempAppPage;
import pompages.TestingPage;
import pompages.contactUsPage;

public class BaseClass {
	protected WebDriverUtility web;
	protected PropertyFileUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jUtil;
	protected WebDriver driver;
	protected HomePage home;
	protected SkillraryDempAppPage demoApp;
	protected TestingPage testing;
	protected SeleniumTraningPage selenium;
	protected contactUsPage contact;
	
	//@BeforeSuite
	//@BeforeTest - not used since there is no parallel execution
	
	@BeforeClass
	public void classConfiguration() {
		web=new WebDriverUtility();
		property = new PropertyFileUtility();
		excel = new ExcelUtility();
		jUtil = new JavaUtility();
		
		property.propertyConfig(IConstantPath.PROPERTIES_PATH);
		String browser = property.fetchProperty("browser");
		String url = property.fetchProperty("url");
		long time = Long.parseLong(property.fetchProperty("time"));
		driver = web.openApplication(browser, url, time);
		
	}
	
	@BeforeMethod
	public void methodConfiguration() {
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		home = new HomePage(driver);
		demoApp = new SkillraryDempAppPage(driver);
		selenium = new SeleniumTraningPage(driver);
		testing = new TestingPage(driver);
		contact = new contactUsPage(driver);
		
		Assert.assertTrue(home.getLogo().isDisplayed());
	}
	
	@AfterMethod
	public void methodTearDown() {
		excel.closeWorkbook();
	}
	//@AfterClass
	//@AfterTest
	//@AfterSuite

}
