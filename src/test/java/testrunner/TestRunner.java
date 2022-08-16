package testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//using JUnit

//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src\\test\\resources\\Features",
//					glue = {"stepdefinition"})
//public class TestRunner {
//
//}

//using TestNG

@CucumberOptions(features = "src\\test\\resources\\Features",
					glue = {"stepdefinition","hooks"},
						plugin = {"pretty","html:target\\CucumberReports\\reports.html"},
						monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests{
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
}