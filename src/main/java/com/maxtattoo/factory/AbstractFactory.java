package com.maxtattoo.factory;

import com.maxtattoo.dto.GenericObject;

public interface AbstractFactory {

    GenericObject getObject(String objectSimpleName);
}
