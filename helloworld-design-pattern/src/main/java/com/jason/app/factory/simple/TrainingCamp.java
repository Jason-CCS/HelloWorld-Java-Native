package com.jason.app.factory.simple;

import com.jason.app.factory._abstract.*;

/**
 * Created by jasonchang on 2017/4/20.
 * 模式名：簡單工廠模式
 * 模式解說：想要什麼東西，生產給你，只要給產品名字，將生產邏輯交給工廠，使用者只負責呼叫（測試程式在test)
 * 範例解說：探險者訓練營，可以訓練出弓箭手與騎士角色。
 */
public class TrainingCamp {
    public static Adventurer trainAdventurer(String type){
        switch (type){
            case "archer":
                Archer archer = new Archer();
                EquipFactory factory = new ArcherEquipFactory();
                archer.setCloth(factory.produceCloth());
                archer.setWeapon(factory.produceWeapon());
                return archer;
            case "knight":
                Knight knight = new Knight();
                EquipFactory factory2 = new KnightEquipFactory();
                knight.setCloth(factory2.produceCloth());
                knight.setWeapon(factory2.produceWeapon());
                return knight;
            default:
                return null;
        }
    }
}
