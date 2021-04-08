package com.tests.api;

import com.apiDictionary.MapsAddPlace;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import static io.restassured.RestAssured.*;
import static com.general.Utils.*;

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

    @Step("Test Maps API : Add New Place")
    @Test
    public void addPlace() throws IOException {

        basePath=getData("maps.addplace.basepath");

        MapsAddPlace mapsAddPlace = new MapsAddPlace();
        mapsAddPlace.addPlaceToMaps();

    }

    @Description("Closing Activities")
    @AfterTest(description = "Teardown Functionality")
    public void tearDown(){

    }

}
