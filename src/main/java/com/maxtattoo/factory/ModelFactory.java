package com.maxtattoo.factory;

import com.maxtattoo.dto.GenericObject;
import com.maxtattoo.dto.model.*;
import com.maxtattoo.service.enums.Model;

public class ModelFactory implements AbstractFactory {

    @Override
    public GenericObject getObject(String objectSimpleName) {
        Model model = Model.findByModelName(objectSimpleName);
        switch(model) {
            case CLIENT_MODEL:
                return new ClientModel();
            case LOCATION_MODEL:
                return new LocationModel();
            case CITY_MODEL:
                return new CityModel();
            case ORDER_MODEL:
                return new OrderModel();
            case ORDER_TYPE_MODEL:
                return new OrderTypeModel();
            case SITTING_MODEL:
                return new SittingModel();
            case PAINT_MODEL:
                return new PaintModel();
            case NEEDLE_MODEL:
                return new NeedleModel();
            case IMAGE_MODEL:
                return new ImageModel();

            default: throw new IllegalArgumentException("Model with name "+objectSimpleName+" does not exist");
        }
    }
}
