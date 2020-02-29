package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DraftsPage {

	WebDriver driver;

	// Every Page must have a constructor to invite the driver
	public DraftsPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.ID, using = "title")
	WebElement DraftTitleField;

	public List<String> getColumnDataFor(String columnHeader) {
		List<String> columnData = new ArrayList<String>();
		int index = getColumnHeaderIndexFor(columnHeader);
		// System.out.println(index);
		String xpath = "//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr[" + index + "]/td/strong/a[" + index + "]";
		List<WebElement> columnDataElements = driver.findElements(By.xpath(xpath));

		for (int i = 0; i < columnDataElements.size(); i++) {
			System.out.println(columnDataElements.get(i).getText());
			columnData.add(columnDataElements.get(i).getText());
		}

		return columnData;
	}

	private int getColumnHeaderIndexFor(String columnHeader) {
		String xpath = "//table[@class='wp-list-table widefat fixed striped posts']/thead/tr[1]/th";
		List<WebElement> columnHeaderElements = driver.findElements(By.xpath(xpath));
		int index = 1;
		for (WebElement element : columnHeaderElements) {
			if (element.getText().equalsIgnoreCase(columnHeader)) {
				return index;
			}
			index++;
		}
		return 0;
	}

}
