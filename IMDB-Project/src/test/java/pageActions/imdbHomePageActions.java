package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BaseClassForPageObjects;
import pageObjects.imdbHomePageObject;


public class imdbHomePageActions  extends BaseClassForPageObjects{
	
imdbHomePageObject imdbHomePageObject = new imdbHomePageObject();
	public void hOverAndClickTop250Movies() {

		Actions action = new Actions(driver);
		WebElement element = imdbHomePageObject.watchList();
		element.click();

		String link = "//label[@for='nav-link-categories-mov']";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.xpath(link))));

		imdbHomePageObject.top250Movies().click();
	}

}
