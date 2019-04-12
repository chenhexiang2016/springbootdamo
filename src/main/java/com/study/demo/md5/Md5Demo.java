package com.study.demo.md5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;

import java.net.URLEncoder;
import java.util.TreeMap;

public class Md5Demo {
    public static void main(String[] args) throws Exception {
        /*1.首先用MD5中DigestUtils.md5Hex(text + key);
        2.text是用TreeMap把username和password装进去，然后转换成json字符串。如：TreeMap t = new TreeMap();t.put(“username”,”23”)…等形式，text为TreeMap 转换的字符串。然后通过DigestUtils.md5Hex(text + key); 加密成md5。

        3.得到的md5值组装一个新字符串 String new = md5值 + “-192.168.1.0” 后面为定义的服务器对外网络固定ip,ip前面要加一个-
        4.然后用3des(DESede)进行对新的值加密：EncryptUtils.Encrypt3DES(new);*/
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("activityId", "11");
        map.put("amount", "1");
        map.put("companyId", "004");
        //转json字符串
        ObjectMapper json = new ObjectMapper();
        String keyy = json.writeValueAsString(map);
        //md5加密
        System.out.println("MD5前："+keyy + "20190226WYXM");
        String tn = DigestUtils.md5Hex(keyy + "20190226WYXM");
        System.out.println("MD5后："+tn);
        //组成新的值
        String ntn = tn + "-" + "139.196.123.11";
        System.out.println("3des前："+ntn);
        //进行3des加密
        String des = EncryptUtils.Encrypt3DES(ntn);
        System.out.println("3des后："+des);
        String res = URLEncoder.encode(des, "utf-8");
        System.out.println("result:"+res);

    }
}
