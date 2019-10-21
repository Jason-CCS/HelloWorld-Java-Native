package com.jason.app.factory.simple;

import com.jason.app.strategy.AttackStrategy;

public interface Adventurer {
    String getType();
    void show();
    void attack();
    void setStrategy(AttackStrategy strategy);
}