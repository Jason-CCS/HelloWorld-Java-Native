package com.jason.app.factory._abstract;

import com.jason.app.factory.simple.Adventurer;
import com.jason.app.factory.simple.TrainingCamp;

/**
 * 模式名：抽象工廠模式
 * 模式解說：抽象工廠介面可以生產兩個以上的產品，抽象工廠模式與工廠方法模式不同的是在於，抽象工廠可以生產一系列的產品族，例如此例
 * 範例解說：探險者裝備製造工廠，分成弓箭手裝備製造工廠和騎士裝備製造工廠
 * 從探險者訓練營(簡單工廠)生產出角色，但在角色訓練期間，必須由裝備生產工廠來給予角色裝備
 * 如弓箭手裝備製造工廠可以製造出leather與bow
 */
class Client {
    public static void main(String[] args) {
        System.out.println("訓練一個弓箭手：");
        Adventurer archer = TrainingCamp.trainAdventurer("archer");
        archer.show();

        System.out.println("訓練一個騎士：");
        Adventurer knight = TrainingCamp.trainAdventurer("knight");
        knight.show();
    }
}