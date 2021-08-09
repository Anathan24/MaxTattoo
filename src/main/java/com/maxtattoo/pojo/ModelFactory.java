package com.maxtattoo.pojo;

import com.maxtattoo.pojo.model.*;

public class ModelFactory {

    private ModelFactory(){}

    public static GenericModel getEntity(String entitySimpleName){
        switch(entitySimpleName){
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

            default: throw new IllegalArgumentException("Entity with name "+entitySimpleName+" does not exist");
        }
    }
}
