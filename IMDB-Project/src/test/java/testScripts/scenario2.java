package testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageActions.imdbHomePageActions;
import pageObjects.BaseClassForPageObjects;

public class scenario2 extends BaseClassForPageObjects {

	@Test
	public void scenarioTwo() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
		Assert.assertTrue(actualTitle.equals(expectedTitle), "Actual and Expected results are not same..!!!");
		Reporter.log("Verified that the imdb website is up and running.", true);

		imdbHomePageActions homePageActions = new imdbHomePageActions();
		homePageActions.hOverAndClickTop250Movies();
		
		String actualTitle1 = driver.getTitle();
		System.out.println(actualTitle1);
		String expectedTitle1 = "Top 250 Movies - IMDb";
		Assert.assertTrue(actualTitle1.equals(expectedTitle1), "Failed to navigated to IMDb Top 250 rated movies page..!!!");
		Reporter.log("Sucessfully Navigated to IMDb Top 250 rated movies page", true);
		
		Reporter.log("Successfully complete the execution of scenario2", true);
	}
}
