package com.apiDictionary;
import io.restassured.http.ContentType;

import java.io.IOException;
import static io.restassured.RestAssured.*;
import static com.general.Utils.*;
import static com.apiPojoToJsonMapping.PojoToJsonMapping.*;
public class JiraApi {

    public void createJira() throws IOException {

        String authorization = encodedAuthToken(getData("jira.user.email"), getData("jira.user.apitoken"));
        String createJiraResponse = given()
                .header("Authorization", "Basic " + authorization)
                .body(createJiraPojoToJson())
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .extract()
                .response().asString();
        System.out.println("createJiraResponse - " + createJiraResponse);
        rememberJsonValueAsString(createJiraResponse, "JiraID", getData("jira.createjiraresponse.jiraidpath"));

    }

    public void getJira() throws IOException {

        String authorization = encodedAuthToken(getData("jira.user.email"), getData("jira.user.apitoken"));
        String getJiraResponse = given()
                .header("Authorization", "Basic " + authorization)
                .when()
                .get()
                .then()
                .extract()
                .response().asString();

        System.out.println("getJiraResponse - " + getJiraResponse);

        rememberJsonValueAsString(getJiraResponse, "JiraDescription", getData("jira.getjiraresponse.jiradescription"));

    }

}