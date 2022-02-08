package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class imbdTop250MoviesPage extends BaseClassForPageObjects{

	public WebElement movieName(int i) {
		return driver.findElement(By.xpath(".//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr[" + i + "]/td[2]/a"));
	}
	
	public WebElement rating(int i) {
		return driver.findElement(By.xpath(".//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr[" + i + "]/td[3]/strong"));
	}
	
	public WebElement yearOfRelease(int i) {
		return driver.findElement(By.xpath(".//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr[" + i + "]/td[2]/span"));
	}

}
