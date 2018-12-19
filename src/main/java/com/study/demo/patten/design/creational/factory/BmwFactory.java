package com.study.demo.patten.design.creational.factory;

public class BmwFactory extends SimpleFactory{

    @Override
    public Car createCar() {
        return new Bmw();
    }
}
