package com.study.demo.patten.design.creational.simplefactory;

public class SimpleFactory {
    public static Car getCar(String type) {
        if ("audi".equalsIgnoreCase(type)) {
            return new Audi();
        } else if ("benz".equalsIgnoreCase(type)) {
            return new Benz();
        } else if ("bwm".equalsIgnoreCase(type)) {
            return new Bmw();
        } else {
            return null;
        }
    }

    /**
     * 反射机制
     */
    public static Car getCar2(Class c) {
        Car car = null;
        try {
            car = (Car) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return car;
    }
}
