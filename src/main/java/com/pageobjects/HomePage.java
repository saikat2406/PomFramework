package com.pageobjects;

import com.general.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SampleFormsPage extends Utils {

    public WebDriver driver;

    private String USERNAME_TEXTBOX = "//input[@id='user' and @type='text']";
    private String PASSWORD_TEXTBOX = "//input[@id='pass' and @type='password']";
    private String LOGIN_BUTTON = "//input[@value='Login']";

    public SampleFormsPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Login with Invalid Credentials")
    public void login(String userid, String password){

        waitForElement(driver, USERNAME_TEXTBOX);
        driver.findElement(By.xpath(USERNAME_TEXTBOX)).sendKeys(userid);
        driver.findElement(By.xpath(PASSWORD_TEXTBOX)).sendKeys(password);
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
        rememberTheValue("name3", "Ujaan");

    }

}
