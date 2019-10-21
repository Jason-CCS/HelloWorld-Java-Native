package com.jason;

public class InstanceInitOrder {
    public InstanceInitOrder() {
        System.out.println("in constructor"); // 7
        classVar = staticFunction();
        instanceVar = memberFunction();
    }

    private static String staticFunction() { // 3
        System.out.println("in static function");
        return "class variable after static function";
    }

    public String memberFunction() { // 6
        System.out.println("in member function");
        return "member variable after member function";
    }

    static String classVar = "class variable"; // 1

    static {
        System.out.println("in static"); //2
        System.out.println(classVar);
    }

    private String instanceVar = "member variable"; // 4

    {
        System.out.println("in instance"); // 5
        System.out.println(instanceVar);
    }

    public static void main(String[] args) {
        InstanceInitOrder instanceInitOrder = new InstanceInitOrder(); // 8
        System.out.println(InstanceInitOrder.classVar);
        System.out.println(instanceInitOrder.instanceVar);
    }
}
