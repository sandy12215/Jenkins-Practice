package stepdefinition;

import org.testng.Assert;

import browser.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screenshot.CaptureScreenshot;

public class Sample1 {
	@Given("user open the browser")
	public void user_open_the_browser() {
	   Browser.setDriver();
	}

	@When("user enters the URL {string}")
	public void user_enters_the_url(String string) throws Exception {
		Browser.getUrl(string);
	}

	@Then("user wants to verify whether the page is loaded or not")
	public void user_wants_to_verify_whether_the_page_is_loaded_or_not() throws Exception {
		try {
			Assert.assertEquals(Browser.getTitle(), "Google");
			CaptureScreenshot.screenShot("sample1");
		}catch (AssertionError e) {
			System.out.println("Error");
		}
	}

	@And("close the browser")
	public void close_the_browser() {
		Browser.closeBrowser();
	}
}
