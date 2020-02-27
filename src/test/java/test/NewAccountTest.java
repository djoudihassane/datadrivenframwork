package test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.FillNewAccountPage;
import page.LoginPage;
import page.NewAccountAdded;
import page.SideNavigation;
import util.BrowserFactory;

public class NewAccountTest {
	WebDriver driver;

	@Test
	@Parameters({ "email", "password", "account_Title", "description", "initial_Balance" })
	public void OpenANewAccount(String email, String password, String account_Title, String description,
			String initial_Balance) throws InterruptedException {
		driver = BrowserFactory.startBrowser();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(email, password);
		SideNavigation navigateto = PageFactory.initElements(driver, SideNavigation.class);
		navigateto.goToNewAccountPage();
		Thread.sleep(3000);
		FillNewAccountPage newaccount = PageFactory.initElements(driver, FillNewAccountPage.class);
		newaccount.fillnewaccount(account_Title, description, initial_Balance);

		NewAccountAdded newaccountvalid = PageFactory.initElements(driver, NewAccountAdded.class);
		List<String> listoftitles = newaccountvalid.getListOf("Account");
		Assert.assertTrue(istitlepresent(account_Title, listoftitles), "Title name was not found");
	}

	private boolean istitlepresent(String account_Title, List<String> columnData) {
		for (String cellData : columnData) {
			if (cellData.equalsIgnoreCase(account_Title)) {
				System.out.println("Displayed Data: " + cellData);
				return true;
			}
		}
		return false;
	}

}
