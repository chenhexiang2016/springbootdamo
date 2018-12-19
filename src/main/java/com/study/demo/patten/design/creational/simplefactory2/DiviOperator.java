package com.study.demo.patten.design.creational.simplefactory2;

public class DiviOperator extends Operator {
    public DiviOperator(double num1, double num2) {
        super(num1, num2);
    }
    @Override
    public double getResult() {
        return num1/num2;
    }
}
