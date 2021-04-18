package com.tests.ui;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelenideTest {

    @Test
    public void selenideTest() {
        open("https://www.mycontactform.com/");
        $(By.xpath("//input[@id='user']")).shouldBe(visible).sendKeys("hello");
        $(By.xpath("//input[@id='pass']")).shouldBe(visible).sendKeys("hello");
        $(By.xpath("//input[@value='Login']")).shouldBe(visible).click();
        Assert.assertEquals($(By.xpath("//div[@id='right_col_top_err']")).getText(),"Incorrect login, please try again.");
        $(By.xpath("//a[text()='Sample Forms']")).click();
        $(By.xpath("//select[@id='q3']")).selectOptionByValue("Second Option");
        Selenide.sleep(3000);
    }

}
