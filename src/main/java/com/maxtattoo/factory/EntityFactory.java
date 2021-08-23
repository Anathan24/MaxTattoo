package com.maxtattoo.factory;

import com.maxtattoo.dto.GenericObject;
import com.maxtattoo.dto.entity.*;

public class EntityFactory implements AbstractFactory {

    @Override
    public GenericObject getObject(String objectSimpleName) {
        switch(objectSimpleName) {
            case "Client":
                return new Client();
            case "Location":
                return new Location();
            case "LocationCity":
                return new LocationCity();
            case "City":
                return new City();
            case "Order":
                return new Order();
            case "OrderType":
                return new OrderType();
            case "Sitting":
                return new Sitting();
            case "SittingNeedle":
                return new SittingNeedle();
            case "Needle":
                return new Needle();
            case "SittingPaint":
                return new SittingPaint();
            case "Paint":
                return new Paint();

            default: throw new IllegalArgumentException("Entity with name "+objectSimpleName+" does not exist");
        }
    }

}
