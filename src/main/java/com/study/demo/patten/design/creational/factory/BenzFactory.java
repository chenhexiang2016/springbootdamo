package com.study.demo.patten.design.creational.factory;

public class BenzFactory extends SimpleFactory{

    @Override
    public Car createCar() {
        return new Benz();
    }
}
