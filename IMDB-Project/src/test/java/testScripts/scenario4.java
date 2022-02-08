package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.BaseClassForPageObjects;
import projectUtils.PropertyFile;
import projectUtils.dataBase;

public class scenario4 extends BaseClassForPageObjects {

	static PropertyFile propertyFile = new PropertyFile();

	@Test
	public void scenarioFour() throws IOException {

		dataBase dataBase = new dataBase();

		appPropertyFile = propertyFile.readProperFile("\\src\\test\\resources\\applicationProperty.properties");

		String url = appPropertyFile.getProperty("url");
		String DBname = appPropertyFile.getProperty("DBname");
		String tabelName = appPropertyFile.getProperty("tabelName");
		String selectQuery = "SELECT * FROM " + tabelName;

		dataBase.selectFromDBAndWriteToHtmlReport(url, DBname, selectQuery);
	}
}
