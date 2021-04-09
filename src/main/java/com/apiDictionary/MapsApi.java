package com.apiDictionary;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import java.io.IOException;
import static com.general.Utils.*;

import static com.apiPojoToJsonMapping.PojoToJsonMapping.addPlacePojoToJson;
import static com.general.Utils.getData;
import static io.restassured.RestAssured.*;

public class MapsApi {

    @Step("API Dictionary : Add Place To Maps")
    public void addPlaceToMaps() throws IOException {

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

        rememberJsonValueAsString(addPlaceResponse, "PlaceID", getData("maps.addplace.jsonpath.placeid"));
        rememberJsonValueAsString(addPlaceResponse, "Status", getData("maps.addplace.jsonpath.status"));

    }

    @Step("API Dictionary : Get Place From Maps")
    public void getPlaceFromMaps() throws IOException {

        String placeDetails = given()
                .queryParam(getData("maps.queryparam.key"), getData("maps.queryparam.value"))
                .queryParam(getData("maps.queryparam.placeid"), whatIsTheValue("PlaceID"))
                .when()
                .get()
                .then()
                .extract()
                .response().asString();

        System.out.println(placeDetails);

        rememberJsonValueAsString(placeDetails, "Latitude", getData("maps.getplace.jsonpath.latitude"));
        rememberJsonValueAsString(placeDetails, "Longitude", getData("maps.getplace.jsonpath.longitude"));
        rememberJsonValueAsString(placeDetails, "Accuracy", getData("maps.getplace.jsonpath.accuracy"));
        rememberJsonValueAsString(placeDetails, "PhoneNumber", getData("maps.getplace.jsonpath.phonenumber"));
        rememberJsonValueAsString(placeDetails, "Address", getData("maps.getplace.jsonpath.address"));
        rememberJsonValueAsString(placeDetails, "Types", getData("maps.getplace.jsonpath.types"));
        rememberJsonValueAsString(placeDetails, "Website", getData("maps.getplace.jsonpath.website"));

    }

}
