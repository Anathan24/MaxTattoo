package com.maxtattoo.factory;

public interface FactoryProducer {

    static AbstractFactory getFactory(String factorySimpleName) {

        switch (factorySimpleName) {
            case "EntityFactory":
                return new EntityFactory();
            case "ModelFactory":
                return new ModelFactory();
            case "StatisticFactory":
                return new StatisticFactory();

            default: throw new IllegalArgumentException("The factory with name "+factorySimpleName+" does not found");
        }
    }
}
