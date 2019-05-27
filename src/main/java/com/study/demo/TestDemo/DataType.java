package com.study.demo.TestDemo;

import java.util.Arrays;

public class DataType {
    public static String sex;
    static {
        System.out.println("DataType.sex"+sex);
        sex = "男";
    }
    private String name;
    private int age;
    {
        System.out.println("DataType.age"+age);
        age = 10;
    }
    public DataType() {
        this("张三",0,0);
    }
    public DataType(String name, int age, int weight) {
        this.name = name;
        this.age = age;
    }
    public void say() {
        System.out.println("姓名："+this.name+"，年龄："+this.age);
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        /*int[] arrA = {1,2,3};
        System.out.println(arrA);
        int[] arrB = {4,5,6,7};
        System.out.println(arrB);
        arrA = arrB;
        arrB = null;
        System.out.println(arrB);
        System.out.println(arrA);*/

        //精度缺失
        /*double a = 0.1*0.2;
        System.out.println(a);*/
        //数据范围溢出
        /*int i = Integer.MAX_VALUE * 2;
        System.out.println(i);

        int a = 1;
        int b = a++ -1;
        System.out.println(a+ " " + b);*/
        final int a0 = 8;
        DataType dataType = new DataType();
        dataType.name = "Kangkang";
        dataType.age = 18;
        dataType.say();
    }
}

