package com.dictionary.basePageObjects;

import static com.general.Utils.*;

import com.dictionary.pageSubComponents.SampleFormsLoginModule;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class SampleFormsPage {

    public WebDriver driver;

    public SampleFormsPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Redirect to Login Module")
    public SampleFormsLoginModule getLoginModule(){
        return new SampleFormsLoginModule(driver);
    }

}
