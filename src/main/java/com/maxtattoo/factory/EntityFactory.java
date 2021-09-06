package com.maxtattoo.factory;

import com.maxtattoo.dto.GenericObject;
import com.maxtattoo.dto.entity.*;
import com.maxtattoo.service.enums.Entity;

public class EntityFactory implements AbstractFactory {

    @Override
    public GenericObject getObject(String objectSimpleName) {
        Entity entity = Entity.findByEntityName(objectSimpleName);
        switch(entity) {
            case CLIENT:
                return new Client();
            case LOCATION:
                return new Location();
            case LOCATION_CITY:
                return new LocationCity();
            case CITY:
                return new City();
            case ORDER:
                return new Order();
            case ORDER_TYPE:
                return new OrderType();
            case SITTING:
                return new Sitting();
            case SITTING_NEEDLE:
                return new SittingNeedle();
            case NEEDLE:
                return new Needle();
            case SITTING_PAINT:
                return new SittingPaint();
            case PAINT:
                return new Paint();

            default: throw new IllegalArgumentException("Entity with name "+objectSimpleName+" does not exist");
        }
    }

}
