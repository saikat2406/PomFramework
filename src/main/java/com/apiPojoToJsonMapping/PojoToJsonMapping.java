package com.apiPojoToJsonMapping;

import com.apiPojo.TestMapsApiPojo.AddPlaceBase;
import com.apiPojo.TestMapsApiPojo.AddPlaceLocation;
import io.qameta.allure.Step;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.general.Utils.getData;

public class PojoToJsonMapping {

    @Step("Converting Pojo to Json Payload")
    public static Object addPlacePojoToJson() throws IOException {

        AddPlaceLocation addPlaceLocation = new AddPlaceLocation();
        addPlaceLocation.setLat(Double.parseDouble(getData("maps.addplace.lat")));
        addPlaceLocation.setLng(Double.parseDouble(getData("maps.addplace.lng")));

        List<String> typesList = new ArrayList<String>();
        typesList.add(getData("maps.addplace.type1"));
        typesList.add(getData("maps.addplace.type2"));
        typesList.add(getData("maps.addplace.type3"));
        typesList.add(getData("maps.addplace.type4"));

        AddPlaceBase addPlaceBase = new AddPlaceBase();
        addPlaceBase.setLocation(addPlaceLocation);
        addPlaceBase.setAccuracy(Integer.parseInt(getData("maps.addplace.accuracy")));
        addPlaceBase.setName(getData("maps.addplace.name"));
        addPlaceBase.setPhone_number(getData("maps.addplace.phone_number"));
        addPlaceBase.setAddress(getData("maps.addplace.address"));
        addPlaceBase.setTypes(typesList);
        addPlaceBase.setWebsite(getData("maps.addplace.website"));
        addPlaceBase.setLanguage(getData("maps.addplace.language"));

        return addPlaceBase;

    }

}
