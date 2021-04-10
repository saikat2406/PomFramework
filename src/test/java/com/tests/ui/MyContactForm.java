package com.tests.ui;

import com.dictionary.basePageObjects.SampleFormsPage;
import com.dictionary.basePageObjects.HomePage;
import static com.general.Utils.*;
import com.engine.DriverManager;
import com.engine.UiTestCase;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class MyContactForm extends DriverManager implements UiTestCase {

    @Description("Setting Up Prerequisites")
    @BeforeTest(description = "Setup Functionality")
    public void setup() throws IOException {
        setTestEnvironment();
    }

    @DataProvider
    public Object[][] getUseridPassword() throws IOException {
        return new Object[][]{
                {getData("userid1"), getData("password1")},
                {getData("userid2"), getData("password2")},
                {getData("userid3"), getData("password3")},
        };
    }

    @Description("MyContactForm : Testing First Invalid Login")
    @Test(description = "Tests First Invalid Login", dataProvider = "getUseridPassword")
    public void firstTest(String userid, String password) throws IOException {

        HomePage homePage = new HomePage(getDriver());
        homePage
                .openWebsite(getData("sampleforms_url"))
                .getNavigationLinks()
                .openSampleForms();
        SampleFormsPage sampleFormsPage = new SampleFormsPage(getDriver());
        sampleFormsPage
                .getLoginModule()
                .login(userid, password);

        Assert.assertEquals(whatIsTheValue("Login Error"), getData("loginerrormessage"));

    }

    @Description("MyContactForm : Testing Second Invalid Login")
    @Test(description = "Tests Second Invalid Login", dataProvider = "getUseridPassword")
    public void secondTest(String userid, String password) throws IOException {

        HomePage homePage = new HomePage(getDriver());
        homePage
                .openWebsite(getData("sampleforms_url"))
                .getNavigationLinks()
                .openSampleForms()
                .getLoginModule()
                .login(userid, password);

        Assert.assertEquals(whatIsTheValue("Login Error"), getData("loginerrormessage"));

    }

    @Description("Closing Activities")
    @AfterTest(description = "Teardown Functionality")
    public void tearDown(){

        quitTest();

    }

}
