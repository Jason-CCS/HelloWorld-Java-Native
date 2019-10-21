package com.jason;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * Created by jc6t on 2015/3/16.
 */
public class ChineseCharLength {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="中文";
        System.out.println(str.getBytes().length); // unicode: 6 = utf-8
        System.out.println(str.getBytes("utf-32").length); // utf-32: 8
        str ="en";
        System.out.println(str.getBytes().length);

        Try t=new Try();
        System.out.println(t.getStr());
    }
}

class Try{
    private String str;
    protected String getStr(){
        return this.str;
    }
}