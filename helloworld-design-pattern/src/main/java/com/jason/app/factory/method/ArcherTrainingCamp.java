package com.jason.app.factory.method;

import com.jason.app.factory._abstract.ArcherEquipFactory;
import com.jason.app.factory._abstract.EquipFactory;
import com.jason.app.factory.simple.Adventurer;
import com.jason.app.factory.simple.Archer;

/**
 * Created by jasonchang on 2017/4/21.
 */
public class ArcherTrainingCamp implements ITrainingCamp {
    @Override
    public Adventurer trainAdventurer() {
        System.out.println("訓練一個弓箭手");
        Archer archer = new Archer();
        EquipFactory factory = new ArcherEquipFactory();
        archer.setCloth(factory.produceCloth());
        archer.setWeapon(factory.produceWeapon());
        return archer;
    }
}
