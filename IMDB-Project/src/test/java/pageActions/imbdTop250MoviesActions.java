package pageActions;

import pageObjects.BaseClassForPageObjects;
import pageObjects.imbdTop250MoviesPage;

public class imbdTop250MoviesActions extends BaseClassForPageObjects{
	
	imbdTop250MoviesPage  imbdTop250MoviesPage = new imbdTop250MoviesPage();
	
	public void clickmovie(int i) {
		imbdTop250MoviesPage.movieName(i).click();
	}
	
	public String getmovie(int i) {
		return imbdTop250MoviesPage.movieName(i).getText().toString();
	}

	public String getrating(int i) {
		return imbdTop250MoviesPage.rating(i).getText().toString();
	}
	
	public String getYearOfRelease(int i) {
		return imbdTop250MoviesPage.yearOfRelease(i).getText().toString();
	}
}
