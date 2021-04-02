package com.dictionary.basePageObjects;

import com.dictionary.pageSubComponents.HomePageNavLinks;
import static com.general.Utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage{

    public WebDriver driver;

    private String SAMPLE_FORMS = "//a[text()='Sample Forms']";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Open MyContactForm Website")
    public HomePage openWebsite(String url) throws IOException {

        driver.get(url);
        waitForElement(driver, SAMPLE_FORMS);
        return new HomePage(driver);

    }

    @Step("Redirect Control to Navigation Links Section")
    public HomePageNavLinks getNavigationLinks(){
        return new HomePageNavLinks(driver);
    }

}
