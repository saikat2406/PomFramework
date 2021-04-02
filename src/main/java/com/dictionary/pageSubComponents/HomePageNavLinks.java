package com.dictionary.pageSubComponents;

import com.dictionary.basePageObjects.SampleFormsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.general.Utils.*;

public class HomePageNavLinks {

    public WebDriver driver;
    public HomePageNavLinks(WebDriver driver){
        this.driver = driver;
    }

    private String SAMPLE_FORMS = "//a[text()='Sample Forms']";
    private String SAMPLE_FORM_HEADER = "//h1[text()='Sample Email and Contact Forms']";

    @Step("Open SampleForm Page")
    public SampleFormsPage openSampleForms(){
        driver.findElement(By.xpath(SAMPLE_FORMS)).click();
        waitForElement(driver, SAMPLE_FORM_HEADER);
        return new SampleFormsPage(driver);
    }

}
