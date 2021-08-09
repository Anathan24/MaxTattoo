package com.maxtattoo.pojo;

import com.maxtattoo.pojo.entity.*;
import org.springframework.stereotype.Service;

@Service
public class EntityFactory {

    private EntityFactory(){}

    public static GenericEntity getEntity(String entitySimpleName){
        switch(entitySimpleName){
            case "Client":
                return new Client();
            case "Location":
                return new Location();
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

            default: throw new IllegalArgumentException("Entity with name "+entitySimpleName+" does not exist");
        }
    }

}
