package com.study.demo.io;

import java.io.UnsupportedEncodingException;

/**
 * @Author: Chenhexiang
 * @Description:
 * @Date: 2019-05-06 10:05
 */
public class ByteLength {
    public static void main(String[] args) {
        String str = "Hello_世界";
        int byteLen = 0;
        try {
            byteLen = str.getBytes("gbk").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            System.out.println("GBK编码的字节长度为："+byteLen);
        }
        byteLen = str.getBytes().length;
        System.out.println("UTF-8编码的字节长度为："+byteLen);
    }
}
