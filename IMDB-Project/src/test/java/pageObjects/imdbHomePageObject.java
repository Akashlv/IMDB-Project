package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class imdbHomePageObject extends BaseClassForPageObjects{

	public WebElement watchList() {
		return driver.findElement(By.xpath("//div[normalize-space()='Menu']"));
		
	}
	
	public WebElement top250Movies() {
		return driver.findElement(By.xpath("(//a[@role='menuitem'])[3]"));
	}
	
}
