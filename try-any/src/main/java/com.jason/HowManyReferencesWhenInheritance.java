package com.jason;

public class HowManyReferencesWhenInheritance {
    public static void main(String[] args) {
        new ChildClass();
    }

}

class ParentClass {
    protected String s = "in ParentClass";
    ParentClass(){
        System.out.println("parent");
        System.out.println(this);
    }
}

class ChildClass extends ParentClass {
    ChildClass(){
        this.s = "in ChildClass";
        System.out.println("child");
        System.out.println(this);
    }
}
