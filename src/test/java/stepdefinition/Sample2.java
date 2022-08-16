package stepdefinition;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.GooglePage;
import pages.Search;
import screenshot.CaptureScreenshot;

public class Sample2 {
	GooglePage obj= new GooglePage();
	@Then("user enters the {string} data")
	public void user_enters_the_data(String string) {
		Search.searchData(string,obj);
	}

	@And("user press enter key")
	public void user_press_enter_key() {
		Search.pressEnterKey();
	}

	@Then("user wants to verify whether search result is displayed in the next page")
	public void user_wants_to_verify_whether_search_result_is_displayed_in_the_next_page() throws Exception {
	   try {
		   String actualSearch= Search.searchResult(obj);
		   Assert.assertEquals(actualSearch, Search.givenTestData());
		   CaptureScreenshot.screenShot("sample2");
	   }catch (AssertionError e) {
		   System.out.println(e.getLocalizedMessage());
	   }
	}
}
