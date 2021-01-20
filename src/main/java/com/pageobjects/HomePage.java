package com.pageobjects;

import com.general.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage extends Utils{

    public WebDriver driver;

    private String SAMPLE_FORMS = "//a[text()='Sample Forms']";
    private String SAMPLE_FORM_HEADER = "//h1[text()='Sample Email and Contact Forms']";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage openWebsite(String url) throws IOException {

        driver.get(url);
        waitForElement(driver, SAMPLE_FORMS);
        rememberTheValue("name1", "Saikat");
        return new HomePage(driver);

    }

    public SampleFormsPage openSampleForms(){
        driver.findElement(By.xpath(SAMPLE_FORMS)).click();
        waitForElement(driver, SAMPLE_FORM_HEADER);
        rememberTheValue("name2", "Sohini");
        return new SampleFormsPage(driver);
    }

}
