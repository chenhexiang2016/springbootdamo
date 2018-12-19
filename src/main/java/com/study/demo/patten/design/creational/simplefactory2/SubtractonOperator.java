package com.study.demo.patten.design.creational.simplefactory2;

public class SubtractonOperator extends Operator {
    public SubtractonOperator(double num1, double num2) {
        super(num1, num2);
    }
    @Override
    public double getResult() {
        return num1-num2;
    }
}
