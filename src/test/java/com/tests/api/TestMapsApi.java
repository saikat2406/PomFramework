package com.tests.api;

import com.apiDictionary.MapsApi;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;

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
    @Test(priority = 1)
    public void addPlace() throws IOException {
        basePath=getData("maps.addplace.basepath");

        MapsApi mapsApi = new MapsApi();
        mapsApi.addPlaceToMaps();

        Assert.assertEquals(whatIsTheValue("Status"), getData("maps.addplace.statusvalue"));
    }

    @Test(priority = 2)
    public void getPlace() throws IOException {
        basePath = getData("maps.getplace.basepath");
        MapsApi mapsApi = new MapsApi();
        mapsApi.getPlaceFromMaps();

        Assert.assertEquals(whatIsTheValue("Latitude"), getData("maps.addplace.lat"));
        Assert.assertEquals(whatIsTheValue("Longitude"), getData("maps.addplace.lng"));
        Assert.assertEquals(whatIsTheValue("Accuracy"), getData("maps.addplace.accuracy"));
        Assert.assertEquals(whatIsTheValue("PhoneNumber"), getData("maps.addplace.phone_number"));
        Assert.assertEquals(whatIsTheValue("Address"), getData("maps.addplace.address"));
        Assert.assertEquals(whatIsTheValue("Types"), getData("maps.addplace.type1")
                + "," + getData("maps.addplace.type2")
                + "," + getData("maps.addplace.type3")
                + "," + getData("maps.addplace.type4"));
        Assert.assertEquals(whatIsTheValue("Website"), getData("maps.addplace.website"));
    }

    @AfterClass
    public void revertDetails() throws IOException {
        reset();
    }

    @Description("Closing Activities")
    @AfterTest(description = "Teardown Functionality")
    public void tearDown(){

    }

}
