package com.jason.app.factory._abstract;

public class ArcherEquipFactory implements EquipFactory {

    @Override
    public Cloth produceCloth() {
        Leather leather = new Leather();
        leather.setDefence(10);
        return leather;
    }

    @Override
    public Weapon produceWeapon() {
        Bow bow = new Bow();
        bow.setAtk(10);
        bow.setRange(5);
        return bow;
    }
}