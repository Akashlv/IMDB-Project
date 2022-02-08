package testScripts;

import java.sql.Connection;
import java.sql.Statement;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.BaseClassForPageObjects;
import projectUtils.dataBase;

public class imdb extends BaseClassForPageObjects{

	Connection conn = null;
	Statement stmt = null;

	String createTableQuery = "CREATE TABLE test(id int,filmname varchar2,rating varchar2,yearofrelease varchar2);";
	String selectQuery = "SELECT * FROM test";
	String connectDBUrl = "jdbc:sqlite:.db";
	String url = "jdbc:sqlite:";
	String DBname = "test";
	String tabelName = "test";
	
	@Test
	public void getTop250MoviesNamesBasedOnRatings() {

		
		dataBase dataBase = new dataBase();
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(".//*[@id='navWatchlistMenu']/p/a"));
		action.moveToElement(we).build().perform();

		String link = ".//*[@id='navWatchlist']/li[3]/a/img";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.xpath(link))));

		driver.findElement(By.xpath(link)).click();

		dataBase.connectToDB(connectDBUrl);
		System.out.println(url);
		System.out.println(DBname);
		System.out.println(tabelName);
		System.out.println(createTableQuery);
		dataBase.createTableInDB(url, DBname, tabelName, createTableQuery);

		for (int i = 1; i < 10; i++) {

			String name = driver.findElement(By.xpath(".//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr[" + i + "]/td[2]/a")).getText().toString();
			String filmRating = driver.findElement(By.xpath(".//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr[" + i + "]/td[3]/strong")).getText().toString();
			String yearOfRelease = driver.findElement(By.xpath(".//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr[" + i + "]/td[2]/span")).getText().toString();
			Reporter.log(i + ". " + name + " released in : " + yearOfRelease + " rating is : " + filmRating, true);

			String filmName = name.replaceAll("'", "");

			String insertIntoTableQuery = "INSERT INTO test (id,filmname,rating,yearofrelease) VALUES ('" + i + "','" + filmName + "','" + filmRating + "','" + yearOfRelease + "');";
			dataBase.inserIntoDB(url, DBname, tabelName, insertIntoTableQuery);
		}

		dataBase.selectFromDB(url, DBname, selectQuery);

	}
}
