package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath ="//body//div//a[13]" )
	//"//div[@class='list-group']//a[text()='Logout']"
	WebElement lnkLogout;
	

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	public void checklogout() {
		
		boolean check = lnkLogout.isDisplayed();
		if(check== true) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			
		}
			
	}
	public void clickLogout() {
		lnkLogout.click();

	}

}
