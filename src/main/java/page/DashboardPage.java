package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "title")
	WebElement DraftTitle;
	@FindBy(how=How.ID, using= "content")
	WebElement ContentText;
	@FindBy(how=How.ID, using="save-post")
	WebElement SaveDraftButton;
	
	public void saveQuickDraft(String draftTitle, String contentText ) {
		DraftTitle.sendKeys(draftTitle);
		ContentText.sendKeys(contentText);
		SaveDraftButton.click();
		
	}


}
