package com.jason.app.bridge;

/**
 * Created by jasonchang on 2017/5/3.
 * 模式名：橋接模式
 * 模式解說：當有兩個以上的東西要組合在一起才能使用時，而且這兩個東西都有更換實作的可能性時。
 * 範例解說：如此例，電腦必須要有作業系統才能使用，而電腦與作業系統都有很多種，所以使用橋接模式將兩個類別聚合起來，
 * 此例華碩電腦要配合某個作業系統，而這邊實作Windows作業系統，將微軟作業系統透過建構子傳入，使華碩電腦可以運作。
 */
public class Client {
    public static void main(String[] args) {
        Asus asus = new Asus(new Windows());
        asus.powerOn();
        asus.doSomthing();
        asus.powerDown();

        Mac mac = new Mac(new Windows());
        mac.powerOn();
        mac.doSomthing();
        mac.powerDown();
    }
}
