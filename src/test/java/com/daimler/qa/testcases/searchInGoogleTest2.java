package com.daimler.qa.testcases;

import com.daimler.listener.TestListener;
import com.daimler.qa.base.TestBase;
import com.daimler.qa.pages.exampleHomePage;
import org.testng.annotations.*;

@Listeners({TestListener.class})

public class searchInGoogleTest2 extends TestBase{

	exampleHomePage homePage;

	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new exampleHomePage();
	}

	@Test(priority=0, description="Test de ejemplo búsqueda en google")
	public void searchGoogle2(){
		homePage.googleSearch(prop.getProperty("textSearch"));

		/*loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		overviewPage.goToIfsOverview();
		ifsOverviewPage.createIfs();
		ifsCreationPopUpPage.fillInIfsCreationPopUp(prop.getProperty("ifsName"),
				prop.getProperty("supplierRepresentative"), prop.getProperty("recoverySpecialist"),
				prop.getProperty("deputyDAI"), prop.getProperty("ifsDescription"));*/
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
