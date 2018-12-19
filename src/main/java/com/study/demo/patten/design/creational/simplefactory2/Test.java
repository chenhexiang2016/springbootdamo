package com.study.demo.patten.design.creational.simplefactory2;

public class Test {
    public static void main(String[] args) {
        Operator operator = OperatorSimpleFactory.createOperate("*", 2, 6);
        if (null == operator) {
            return;
        }
        System.out.println("计算结果是："+operator.getResult());
    }
}
