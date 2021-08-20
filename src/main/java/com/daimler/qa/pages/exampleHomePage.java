package com.daimler.qa.pages;

import com.daimler.qa.base.TestBase;
import com.daimler.qa.pom.ExampleHomePagePOM;
import io.qameta.allure.Step;

public class exampleHomePage extends TestBase {
    //All WAYS in your page - > REUSABLE
    ExampleHomePagePOM exampleHomePage = new ExampleHomePagePOM();
    private ExampleHomePagePOM exampleHomePage1;

    @Step("Realizamos una búsqueda en google")
    public void googleSearch(String textSearch){
        exampleHomePage.btnAcceptGootle();
        exampleHomePage.fieldSearch(textSearch);
        exampleHomePage.btnSearch();
    }


}
