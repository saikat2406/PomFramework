package com.apiDictionary;

import io.qameta.allure.Step;

import java.io.IOException;

import static com.apiPojoToJsonMapping.PojoToJsonMapping.addPlacePojoToJson;
import static com.general.Utils.getData;
import static io.restassured.RestAssured.*;

public class MapsAddPlace {

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

    }

}
