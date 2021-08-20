package com.daimler.qa.pom;

import com.daimler.qa.base.TestBase;
import org.openqa.selenium.By;
import com.daimler.qa.pages.exampleHomePage;


public class ExampleHomePagePOM extends TestBase {
	// all page elements and ACTIONS with it.

	public void btnSearch(){
		String btnSearch="/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]";
		driver.findElement(By.xpath(btnSearch)).click();
	}

	public void fieldSearch(String textSearch){
		String fieldSearch="/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input";
		driver.findElement(By.xpath(fieldSearch)).sendKeys(textSearch);
	}

	public void btnAcceptGootle(){
		String acceptGoogle="//*[@id=\"L2AGLb\"]";
		driver.findElement(By.xpath(acceptGoogle)).click();
	}


}



