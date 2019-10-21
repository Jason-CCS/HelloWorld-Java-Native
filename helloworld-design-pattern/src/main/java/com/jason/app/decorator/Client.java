package com.jason.app.decorator;

import com.jason.app.adapter.Adapter;
import com.jason.app.adapter.Wizard;

/**
 * 模式名：裝飾模式
 * 模式解說：讓某物件裝飾上某特性，使該物件有該特性，
 * 範例解說：如讓長槍兵使出長槍攻擊時，可以加上強力特性，使他可以使出強力長槍攻擊，
 * 此設計模式在現有function上，附加上function外的功能。
 */
public class Client
{
    public static void main( String[] args )
    {
        System.out.println("--- 測試 Decorator 模式 ---");

        System.out.println("--- 創建長槍兵 Jason ---");
        Lancer lancer = new Lancer("Jason");
        lancer.attack();
        System.out.println();

        System.out.println("--- 加上強壯稱號: ---");
        StrongDecorator sLancer=new StrongDecorator(lancer);
        sLancer.attack();
        System.out.println();

        System.out.println("--- 再加上敏捷稱號： ---");
        AgileDecorator asLancer = new AgileDecorator(sLancer);
        asLancer.attack();
        System.out.println();

        System.out.println("--- 再加上火焰稱號： ---");
        FireDecorator fasLancer = new FireDecorator(asLancer);
        fasLancer.attack();
        System.out.println();

        System.out.println("--- 轉換成法師： ---");
        Wizard wizard = new Adapter(lancer);
        wizard.fireBall();
        System.out.println();
    }
}
