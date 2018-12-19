package com.study.demo.patten.design.creational.simplefactory2;

public class AddOperator extends Operator {
    public AddOperator(double num1, double num2) {
        super(num1, num2);
    }
    @Override
    public double getResult() {
        return num1+num2;
    }
}
