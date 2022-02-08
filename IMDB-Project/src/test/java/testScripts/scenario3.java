package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageActions.imbdTop250MoviesActions;
import pageActions.imdbHomePageActions;
import pageObjects.BaseClassForPageObjects;
import projectUtils.PropertyFile;
import projectUtils.dataBase;

public class scenario3 extends BaseClassForPageObjects {

	static PropertyFile propertyFile = new PropertyFile();

	@Test
	public void scenarioThree() throws IOException {

		dataBase dataBase = new dataBase();

		String actualTitle = driver.getTitle();
		String expectedTitle = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
		Assert.assertTrue(actualTitle.equals(expectedTitle), "Actual and Expected results are not same..!!!");
		Reporter.log("Verified that the imdb website is up and running.", true);

		imdbHomePageActions homePageActions = new imdbHomePageActions();
		homePageActions.hOverAndClickTop250Movies();
		imbdTop250MoviesActions imbdTop250MoviesActions = new imbdTop250MoviesActions();

		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Top 250 Movies - IMDb";
		Assert.assertTrue(actualTitle1.equals(expectedTitle1), "Failed to navigated to IMDb Top 250 rated movies page..!!!");
		Reporter.log("Sucessfully Navigated to IMDb Top 250 rated movies page", true);

		appPropertyFile = propertyFile.readProperFile("\\src\\test\\resources\\applicationProperty.properties");

		String url = appPropertyFile.getProperty("url");
		String DBname = appPropertyFile.getProperty("DBname");
		String tabelName = appPropertyFile.getProperty("tabelName");

		String createTableQuery = "CREATE TABLE " + tabelName + "(id int,filmname varchar2,rating varchar2,yearofrelease varchar2);";

		dataBase.connectToDB(appPropertyFile.getProperty("connectDBUrl"));
		dataBase.createTableInDB(url, DBname, tabelName, createTableQuery);

		for (int i = 1; i < 251; i++) {

			String name = imbdTop250MoviesActions.getmovie(i);
			String filmRating = imbdTop250MoviesActions.getrating(i);
			String yearOfRelease = imbdTop250MoviesActions.getYearOfRelease(i);
			Reporter.log(i + ". " + name + " released in : " + yearOfRelease + " rating is : " + filmRating, true);

			String filmName = name.replaceAll("'","");

			String insertIntoTableQuery = "INSERT INTO " + tabelName + "(id,filmname,rating,yearofrelease) VALUES ('" + i + "','" + filmName + "','" + filmRating + "','" + yearOfRelease + "');";
			dataBase.inserIntoDB(url, DBname, tabelName, insertIntoTableQuery);
		}
		Reporter.log("Successfully complete the execution of scenario3", true);
	}
}
