package com.study.demo.patten.design.creational.factory;

public class AudiFactory extends SimpleFactory{

    @Override
    public Car createCar() {
        return new Audi();
    }
}
