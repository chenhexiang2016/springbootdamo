package com.study.demo.patten.design.creational.simplefactory;

public class Test {
    public static void main(String[] args) {
        Car car = SimpleFactory.getCar("benz");
        if (car == null) {
            return;
        }
        car.type();

        Car car2 = SimpleFactory.getCar2(new Bmw().getClass());
        car2.type();
    }
}
