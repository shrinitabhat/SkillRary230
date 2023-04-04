package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class Test2 extends BaseClass {
	
	@Test
	public void test2() {
		SoftAssert soft = new SoftAssert();
		
		home.clickGearsTab();
		home.clickSkillRaryDemoApp();
		web.handleChildBrowser();
		
		soft.assertEquals(demoApp.getPageHeader(), "SkillRary-ECommerce");
		
		demoApp.selectCategory(web, 1);
		
		web.dragAndDropElement(testing.getSeleniumTrainingImage(),testing.getCartArea());
		
		web.scrollTillElement(testing.getFacebookIcon());
		testing.ClickFacebookIcon();
		
		soft.assertAll();
	}
}
