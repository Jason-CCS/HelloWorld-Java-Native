package com.jason.app.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonchang on 2017/5/12.
 * 模式名：訪問者模式
 * 模式解說：當有一些物件必須被一些特定功能(Visitor)來進行檢視與紀錄時，因為這些物件的數量是固定的，
 * 所以只要寫一個interface讓這些物件可以accept(visitor)，然後再撰寫Visitor的實作功能，就可以取得這些物件的資料，
 * 而有不同訪問實作時，也可以快速擴充，此模式的缺點乃是，如果有新的物件要被增加，必須修改Visit介面。
 * 範例解說：此範例設定三個物件，狗，男人，女人，並且以是否會開車，身體檢查，詢問興趣的訪問角度來查看。
 */
public class Client {
    public static void main(String[] args) {
        List<Element> list = new ArrayList<>();
        list.add(new Man("Tom", 170, 66));
        list.add(new Woman("Mary", 160, 55));
        list.add(new Dog("Gigi", 60, 18));

        // 用開車的角度來看狗男女
        list.forEach(e -> e.accept(new CarDriveVisitor()));
        // 用身體數值的角度來看狗男女
        list.forEach(e -> e.accept(new BodyVisitor()));
        // 用興趣的角度來看狗男女
        list.forEach(e -> e.accept(new HobbyVisitor()));

    }
}
