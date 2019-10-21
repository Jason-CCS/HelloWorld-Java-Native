package com.jason.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jc6t on 2015/3/2.
 */
public class RegX {


    public static void main(String[] args) {
        String testStr="abc123^_^";
        Pattern pattern=Pattern.compile("[a-c]*");
        Matcher match=pattern.matcher(testStr);
        if(match.find()){
            for(int i=0;i<=match.groupCount();i++)
                System.out.println(match.group(i));
        }else {
            System.out.println("no found");
        }
    }
}
