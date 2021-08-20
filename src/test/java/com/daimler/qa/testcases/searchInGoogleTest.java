package com.daimler.qa.testcases;

import com.daimler.qa.base.TestBase;
import com.daimler.qa.pages.exampleHomePage;
import com.daimler.listener.TestListener;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.*;

@Listeners({TestListener.class})

public class searchInGoogleTest extends TestBase{

	exampleHomePage homePage;

	@BeforeClass
	public void setUp(){
		initialization();
		homePage = new exampleHomePage();
	}

	@Test(priority=0, description="Test de ejemplo búsqueda en google")
	public void searchGoogle(){
		homePage.googleSearch(prop.getProperty("textSearch"));

	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
