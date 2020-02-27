package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FillNewAccountPage {

	WebDriver driver;
	
	public FillNewAccountPage(WebDriver driver){
		this.driver=driver;	
	}
	@FindBy(how = How.ID, using = "account")
	WebElement Account_title;
	@FindBy(how = How.ID, using = "description")
	WebElement Description;
	@FindBy(how = How.ID, using = "balance")
	WebElement Balance;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	WebElement Submit;
	
	
	public void fillnewaccount(String account ,String description ,String balance) {
		Random rnd = new Random();
		Account_title.sendKeys(account+rnd.nextInt(999));
		Description.sendKeys(description);
		Balance.sendKeys(balance);
		Submit.click();
	}



	



		
	}


	
	
	
	
	
	
	

