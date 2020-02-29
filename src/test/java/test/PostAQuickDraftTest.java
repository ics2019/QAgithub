package test;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.DraftsPage;
import page.LoginPage;
import page.SideNavigation;
import util.BrowserFactory;

public class PostAQuickDraftTest {
	WebDriver driver;
	@Test
	public void addQuickDraft() throws InterruptedException {
	
		driver= BrowserFactory.startBrowser();
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		loginPage.logIn("opensourcecms", "opensourcecms");
		
		DashboardPage dashPage= PageFactory.initElements(driver, DashboardPage.class);
		
		Random rnd= new Random();
		String expectedDraftTitle="NewTitle#"+rnd.nextInt(999);
		String contentText="This is new content #"+rnd.nextInt(999);
		
		dashPage.saveQuickDraft(expectedDraftTitle, contentText);
		SideNavigation sideNavigation=PageFactory.initElements(driver, SideNavigation.class);
		sideNavigation.goToPostsMenu();
		
		DraftsPage draftsPage = PageFactory.initElements(driver, DraftsPage.class);
		List<String> columnData = draftsPage.getColumnDataFor("Title");
		Assert.assertTrue(isDataPresent(expectedDraftTitle, columnData), "New draft did not post!!!!");
	
		
	
	}
	@AfterMethod
	public void close() {
		driver.close();
		driver.quit();
		
		
	}
	
	private boolean isDataPresent(String expectedTitle, List<String> columnData) {
		for (String cellData : columnData) {
			if (cellData.equalsIgnoreCase(expectedTitle)) {
				System.out.println("Displayed Data: " + cellData);
				return true;
			}
		}
		return false;
	}

}
