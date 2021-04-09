package com.tests.api;

import com.apiDictionary.JiraApi;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static com.general.Utils.*;
import static com.general.Utils.getData;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class TestJiraApi {

    @Description("Setting Up Prerequisites")
    @BeforeTest(description = "Setup Functionality")
    public void setup() throws IOException {
        setTestEnvironment();
    }

    @BeforeClass
    public void setBaseUri() throws IOException {
        baseURI=getData("jira.allresources.basepath");
    }

    @Step("Test Jira API : Create New Jira")
    @Test(priority = 1)
    public void createJira() throws IOException {
        basePath=getData("jira.create.basepath");

        JiraApi jiraApi = new JiraApi();
        jiraApi.createJira();

        System.out.println(whatIsTheValue("JiraID"));
    }

    @Step("Test Jira API : Get Jira")
    @Test(priority = 2)
    public void getJira() throws IOException {
        basePath = cleanBasePath(getData("jira.get.basepath"), whatIsTheValue("JiraID"));
        JiraApi jiraApi = new JiraApi();
        jiraApi.getJira();

        System.out.println(whatIsTheValue("JiraDescription"));
        Assert.assertEquals(whatIsTheValue("JiraDescription"), getData("jira.create.description"));
    }

    @AfterClass
    public void revertDetails() throws IOException {
        baseURI="";
    }

    @Description("Closing Activities")
    @AfterTest(description = "Teardown Functionality")
    public void tearDown(){

    }

}
