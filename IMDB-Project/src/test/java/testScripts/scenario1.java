package testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.BaseClassForPageObjects;

public class scenario1 extends BaseClassForPageObjects {

	@Test
	public void scenarioOne() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
		System.out.println(driver.getTitle());
		Assert.assertTrue(actualTitle.equals(expectedTitle), "Actual and Expected results are not same..!!!");
		Reporter.log("Verified that the imdb website is up and running.", true);
		Reporter.log("Successfully complete the execution of scenario1", true);
		
	}
}
