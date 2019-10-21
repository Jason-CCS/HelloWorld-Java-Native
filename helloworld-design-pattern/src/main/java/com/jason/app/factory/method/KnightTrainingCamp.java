package com.jason.app.factory.method;

import com.jason.app.factory._abstract.EquipFactory;
import com.jason.app.factory._abstract.KnightEquipFactory;
import com.jason.app.factory.simple.Adventurer;
import com.jason.app.factory.simple.Knight;

/**
 * Created by jasonchang on 2017/4/21.
 */
public class KnightTrainingCamp implements ITrainingCamp {
    @Override
    public Adventurer trainAdventurer() {
        System.out.println("訓練一個騎士");
        Knight knight = new Knight();
        EquipFactory factory = new KnightEquipFactory();
        knight.setCloth(factory.produceCloth());
        knight.setWeapon(factory.produceWeapon());
        return knight;
    }
}
