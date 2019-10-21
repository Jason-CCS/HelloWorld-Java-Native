package com.jason.app.builder;

/**
 * Created by jasonchang on 2017/4/21.
 * 模式名：建造者模式
 * 模式解說：建造非常複雜的產品，並且開放控制(Director)給客戶端，建造者模式與抽象工廠模式不同的地方在於，
 * 建造者模式只生產單一複雜產品，並開放控制給客戶端，抽象工廠則完全閉鎖，而且可以生產一群產品系列
 * 範例解說：此範例是一個消費者在麥當勞點餐的範例，waiter是Director的角色，mealBuilder是ConcreteBuilder的角色，
 * 客戶端點一個套餐A，服務生知道套餐A有哪些東西，服務生要求mealBuilder製作這些餐點給他，但是服務生不管如何製作的，
 * mealBuilder負責製造邏輯，並且返回meal給服務生。
 */
public class Client {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        System.out.println("消費者一要套餐A");
        Meal meal = waiter.getMealA();
        System.out.println(meal);
        System.out.println();

        System.out.println("消費者二要套餐B");
        meal = waiter.getMealB();
        System.out.println(meal);
        System.out.println();

        System.out.println("消費者三要兒童餐");
        meal = waiter.getMealC();
        System.out.println(meal);
        System.out.println();
    }
}
