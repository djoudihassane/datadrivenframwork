package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewAccountAdded {

	WebDriver driver;

	public NewAccountAdded(WebDriver driver) {

		this.driver = driver;

	}

	@FindBy(how = How.ID, using = "account")
	WebElement Account;

	public List<String> getListOf(String columnName) {
		List<String> list = new ArrayList<String>();
		int HeaderIndex = getHeaderINdex(columnName);
		List<WebElement> columdataelement = driver.findElements(By.xpath("//tbody//td[" + HeaderIndex + "]"));
		for (int i = 0; i < columdataelement.size(); i++) {
			list.add(i, columdataelement.get(i).getText());

		}
		return list;
	}

	private int getHeaderINdex(String columnName) {
		List<WebElement> elements = driver.findElements(By.xpath("//table/descendant::th"));

		for (int i = 0; i <= elements.size(); i++) {

			if (elements.get(i).getText().equalsIgnoreCase(columnName))
				;
			{
				return i + 1;
			}
		}
		return 0;
	}

}
