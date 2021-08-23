package com.maxtattoo.factory;

import com.maxtattoo.dto.GenericObject;
import com.maxtattoo.dto.model.*;

public class ModelFactory implements AbstractFactory {

    @Override
    public GenericObject getObject(String objectSimpleName) {
        switch(objectSimpleName){
            case "ClientModel":
                return new ClientModel();
            case "LocationModel":
                return new LocationModel();
            case "CityModel":
                return new CityModel();
            case "OrderModel":
                return new OrderModel();
            case "OrderTypeModel":
                return new OrderTypeModel();
            case "SittingModel":
                return new SittingModel();
            case "NeedleModel":
                return new NeedleModel();
            case "PaintModel":
                return new PaintModel();

            default: throw new IllegalArgumentException("Model with name "+objectSimpleName+" does not exist");
        }
    }
}
