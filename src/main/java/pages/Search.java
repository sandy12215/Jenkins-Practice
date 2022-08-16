package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import browser.Browser;
import pageobjects.GooglePage;

public class Search extends Browser{
	
	static WebElement search;
	static WebElement resultSearch;
	
	
	static String testData=null;
	public static void searchData(String data,GooglePage obj) {
		testData=data;
//		search= driver.findElement(By.name("q"));
//		search.sendKeys(data);
				
		search= obj.searchElement(); //Using Page Factory Object
		search.sendKeys(data);
	}

	public static void pressEnterKey() {
		search.sendKeys(Keys.ENTER);
	}

	public static String searchResult(GooglePage obj) {
//		resultSearch= driver.findElement(By.name("q"));
		resultSearch= obj.searchElement();//Using Page Factory Object
		return resultSearch.getAttribute("value");
	}
	public static String givenTestData() {
		return testData;
	}
}
