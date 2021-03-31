package com.tests;

import com.engine.DriverManager;
import com.dictionary.pageobjects.HomePage;
import com.general.Utils;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyContactForm extends DriverManager {

    @Description("MyContactForm : Testing Invalid Login")
    @Test(description = "Tests Invalid Login")
    public void mainTest() throws IOException {

        HomePage homePage = new HomePage(getDriver());
        homePage
                .openWebsite(Utils.getData("sampleforms_url"))
                .openSampleForms()
                .login(Utils.getData("userid"), Utils.getData("password"));

        System.out.println(Utils.whatIsTheValue("name1"));
        System.out.println(Utils.whatIsTheValue("name2"));
        System.out.println(Utils.whatIsTheValue("name3"));

        Assert.assertEquals(Utils.whatIsTheValue("name1"), "Saikat");
        Assert.assertEquals(Utils.whatIsTheValue("name2"), "Sohini");
        Assert.assertEquals(Utils.whatIsTheValue("name3"), "Ujaan");

    }

}
