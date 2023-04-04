package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all the elements and respective business libraries of home page
 * @author Admin
 *
 */
public class HomePage {
	
	//Declarartion
	@FindBy(xpath="//img[@alt='SkillRary']")
	private WebElement logo;
	
	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearsTab;
	
	@FindBy(xpath="//ul[@class='dropdown-menu gear_menu']/descendant::a[text()=' SkillRary Demo APP']")
	private WebElement skillraryDemoAppLink;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	/**
	 * This methods returns the skillrary logo
	 * @return
	 */
	public WebElement getLogo() {
		return logo;
	}
	
	/**
	 * This method is used to click on gears tab
	 */
	public void  clickGearsTab() {
		gearsTab.click();
	}
	
	public void clickSkillRaryDemoApp() {
		skillraryDemoAppLink.click();
	}

}
