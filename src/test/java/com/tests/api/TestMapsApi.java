package com.tests.api;

import io.qameta.allure.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import static io.restassured.RestAssured.*;
import static com.general.Utils.*;
import static com.apiPojoToJsonMapping.PojoToJsonMapping.*;

public class TestMapsApi {

    @Description("Setting Up Prerequisites")
    @BeforeTest(description = "Setup Functionality")
    public void setup() throws IOException {
        setTestEnvironment();
    }

    @BeforeClass
    public void setBaseUri() throws IOException {
        baseURI=getData("maps.allresources.basepath");
    }

    @Description("Test Maps API : Add New Place")
    @Test
    public void addPlace() throws IOException {

        basePath=getData("maps.addplace.basepath");

        String addPlaceResponse = given()
                .queryParam(getData("maps.queryparam.key"), getData("maps.queryparam.value"))
                .body(addPlacePojoToJson())
                .when()
                .post()
                .then()
                .statusCode(Integer.parseInt(getData("maps.addplace.statuscode")))
                .extract()
                .response().asString();

        System.out.println(addPlaceResponse);

    }

    @Description("Closing Activities")
    @AfterTest(description = "Teardown Functionality")
    public void tearDown(){

    }

}
