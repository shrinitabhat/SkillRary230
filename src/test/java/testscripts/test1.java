package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class test1 extends BaseClass {
	
	@Test
	
	public void test1() {
		SoftAssert soft = new SoftAssert();
		
		home.clickGearsTab();
		home.clickSkillRaryDemoApp();
		web.handleChildBrowser();
		soft.assertEquals(demoApp.getPageHeader(), "SkillRary-ECommerce");
		
		demoApp.mouseHoverToCourse(web);
		demoApp.clickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(), "Selenium Training");
		selenium.doubleClickAdd(web);
		selenium.clickAddToCart();
		
		web.handleAlert("OK");
		soft.assertEquals(selenium.getItemAddedMessage(), "Item added to cart");
		
		soft.assertAll();
		
		
	}

}
