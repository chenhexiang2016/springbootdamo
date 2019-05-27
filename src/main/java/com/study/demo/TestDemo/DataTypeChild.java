package com.study.demo.TestDemo;

public class DataTypeChild extends DataType {
    public static String sex;
    static {
        System.out.println("DataTypeChild.sex"+sex);
        sex = "女";
    }
    private int age;
    {
        System.out.println("DataTypeChild.age"+age);
        age = 1;
    }
}
