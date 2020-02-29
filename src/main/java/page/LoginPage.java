package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "user_login")
	WebElement UserName;
	@FindBy(how= How.ID, using= "user_pass")
	WebElement Password; 
	@FindBy(how=How.ID, using= "wp-submit")
	WebElement Submit_Button;
	
	
	public void logIn(String username,String password) {
		UserName.sendKeys(username);
		Password.sendKeys(password);
		Submit_Button.click();
	}
	
	
}
