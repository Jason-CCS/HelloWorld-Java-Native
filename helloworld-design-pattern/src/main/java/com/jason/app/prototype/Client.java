package com.jason.app.prototype;

import com.jason.app.decorator.Lancer;

/**
 * Created by jasonchang on 2017/2/23.
 * 模式名：prototype原型設計模式
 * 模式解說：使某物件可被複製，新的實體，此方法super.clone()被網路說是有bug的，最好自己寫一個新的。
 * 範例解說：做一個可以被複製的Lancer
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("--- 創建長槍兵 Jason ---");
        Lancer jason = new Lancer("Jason");
        jason.attack();
        System.out.println();

        System.out.println("--- 創建可複製的長槍兵 Shadow ---");
        Shadow s = new Shadow("Shadow");
        s.attack();
        System.out.println();

        System.out.println("--- 複製一個 Shadow出來 ---");
        Shadow s2= (Shadow) s.clone();
        s2.attack();
        System.out.println();

        System.out.println("--- 修改s2的名字為 Shadow2，並顯示原本的shadow攻擊，兩者的名字應該不同，如果相同代表同一個記憶體 ---");
        System.out.println("-- Shadow2攻擊 ---");
        s2.setName("Shadow2");
        s2.attack();
        System.out.println();
        System.out.println("--- Shadow攻擊 ---");
        s.attack();
        System.out.println();
        String str = "abc";
    }
}
