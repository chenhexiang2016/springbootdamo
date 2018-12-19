package com.study.demo.patten.design.creational.simplefactory2;

public class OperatorSimpleFactory {
    public static Operator createOperate(String type, double num1, double num2) {
        Operator operator = null;
        switch (type) {
            case "+":
                operator = new AddOperator(num1, num2);
                break;
            case "-":
                operator = new SubtractonOperator(num1, num2);
            break;
            case "*":
                operator = new MultiOperator(num1, num2);
            break;
            case "/":
                operator = new DiviOperator(num1, num2);
            break;
            default:

                break;
        }
        return operator;
    }
}
