package com.study.demo.patten.design.creational.factory;

public class Test {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new ExtFactory();
        Car car = simpleFactory.createCar();
        car.type();
    }
}
