package com.jason.app.factory._abstract;

public class KnightEquipFactory implements EquipFactory {
    @Override
    public Cloth produceCloth() {
        Armour armour = new Armour();
        armour.setDefence(50);
        return armour;
    }

    @Override
    public Weapon produceWeapon() {
        Sword sword = new Sword();
        sword.setAtk(20);
        sword.setRange(1);
        return sword;
    }
}