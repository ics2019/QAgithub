package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SideNavigation {
	
	WebDriver driver;
	
	public SideNavigation(WebDriver driver) {
		this.driver=driver;
				
	}
	
	////
	@FindBy(how=How.ID, using="menu-posts")
	WebElement PostsMenu;
	@FindBy(how=How.LINK_TEXT, using="All Posts")
	WebElement AllPosts;
	
	

	public void goToPostsMenu() throws InterruptedException {
		Thread.sleep(3000);
		PostsMenu.click();
		Thread.sleep(3000);
		AllPosts.click();
		
	}
	
	
}
