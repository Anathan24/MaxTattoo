package com.maxtattoo.factory;

import com.maxtattoo.pojo.GenericObject;

public interface AbstractFactory {

    GenericObject getObject(String objectSimpleName);
}
