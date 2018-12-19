package com.study.demo.patten.design.creational.factory;

public class ExtFactory extends SimpleFactory{

    @Override
    public Car createCar() {
        return new Ext();
    }
}
