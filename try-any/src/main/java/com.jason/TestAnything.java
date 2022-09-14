package com.jason;

public class TestAnything {

    public TestAnything(String s){
        this.aString = s;
        System.out.println("in constructor");
    }

    public String aString;
    public String bString = aString + "456";
    public String cString = bString + "789";
}
