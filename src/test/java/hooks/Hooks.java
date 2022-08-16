package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {
	@Before
	public void method1() {
		System.out.println("Launching the Browser");
	}
	@After
	public void method2() {
		System.out.println("Closing the Browser");
	}
	@Before("@first")
	public void method5() {
		System.out.println("First Feature file");
	}
	@Before("@second")
	public void method6() {
		System.out.println("Second Feature file");
	}
	@BeforeStep
	public void method3() {
		System.out.println("Before Step");
	}
	@AfterStep
	public void method4() {
		System.out.println("After Step");
	}
}
