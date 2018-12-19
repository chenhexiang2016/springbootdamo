package com.study.demo.patten.design.creational.simplefactory2;

public abstract class Operator {
    protected double num1;
    protected double num2;

    protected Operator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract double getResult();
}
