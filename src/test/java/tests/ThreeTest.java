package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{
	
	@Test
	public void testThree() throws IOException, InterruptedException {

		System.out.println("TestThree runs.");

		WebDriver driver = initializeDriver();
		
		driver.get("http://tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		
		driver.close();

	}

}
