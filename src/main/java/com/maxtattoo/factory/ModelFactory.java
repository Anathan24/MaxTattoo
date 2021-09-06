package com.maxtattoo.factory;

import com.maxtattoo.dto.GenericObject;
import com.maxtattoo.dto.model.*;
import com.maxtattoo.service.enums.Model;

public class ModelFactory implements AbstractFactory {

    @Override
    public GenericObject getObject(String objectSimpleName) {
        Model model = Model.findByModel(objectSimpleName);
        switch(model) {
            case CLIENT:
                return new ClientModel();
            case LOCATION:
                return new LocationModel();
            case CITY:
                return new CityModel();
            case ORDER:
                return new OrderModel();
            case ORDER_TYPE:
                return new OrderTypeModel();
            case SITTING:
                return new SittingModel();
            case PAINT:
                return new PaintModel();
            case NEEDLE:
                return new NeedleModel();

            default: throw new IllegalArgumentException("Model with name "+objectSimpleName+" does not exist");
        }
    }
}
