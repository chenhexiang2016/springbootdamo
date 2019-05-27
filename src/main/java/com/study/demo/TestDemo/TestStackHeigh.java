package com.study.demo.TestDemo;

//栈溢出
public class TestStackHeigh {
    public int count = 0;
    public void testStack() {
//        count++;
        String ss = "ceshi" + count;
        testStack();
    }

    public void test() {
        try {
            testStack();
        } catch (Throwable e) {
            System.out.println(e);
            System.out.println("stack heigh:"+count);
        }
    }

    public static void main(String[] args) {
//        new TestStackHeigh().test();
        /*long arr[];
        for (int i=1; i<=10000000; i*=2) {
            arr = new long[i];
        }*/
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c==d);//true
        System.out.println(e==f);//false
        System.out.println(c==(a+b));//false  true
        System.out.println(c.equals(a+b));//true
        System.out.println(g==(a+b));//false  true
        System.out.println(g.equals(a+b));//true
        System.out.println(g.equals(c));//true false
        Boolean ss = true;
        System.out.println(ss.toString());

    }
}
