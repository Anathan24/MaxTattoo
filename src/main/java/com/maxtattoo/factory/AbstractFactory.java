package com.maxtattoo.factory;

import com.maxtattoo.bean.GenericObject;

public interface AbstractFactory {

    GenericObject getObject(String objectSimpleName);
}
