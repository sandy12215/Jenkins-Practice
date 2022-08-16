package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import browser.Browser;

public class GooglePage extends Browser{
	public GooglePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "q")
	WebElement searchText;
	public WebElement searchElement() {
		return searchText;
	}
}
