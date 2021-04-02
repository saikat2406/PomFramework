package com.dictionary.pageSubComponents;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.general.Utils.rememberTheValue;
import static com.general.Utils.waitForElement;

public class SampleFormsLoginModule {

    WebDriver driver;
    public SampleFormsLoginModule(WebDriver driver){
        this.driver = driver;
    }

    private String USERNAME_TEXTBOX = "//input[@id='user' and @type='text']";
    private String PASSWORD_TEXTBOX = "//input[@id='pass' and @type='password']";
    private String LOGIN_BUTTON = "//input[@value='Login']";
    private String errorMessage = "//div[@id='right_col_top_err']";

    @Step("Perform Login With Invalid Details")
    public void login(String userid, String password){

        waitForElement(driver, USERNAME_TEXTBOX);
        driver.findElement(By.xpath(USERNAME_TEXTBOX)).sendKeys(userid);
        driver.findElement(By.xpath(PASSWORD_TEXTBOX)).sendKeys(password);
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
        String loginError = driver.findElement(By.xpath(errorMessage)).getText().trim();
        rememberTheValue("Login Error", loginError);

    }

}
