package com.jason.app.factory.method;

import com.jason.app.factory.simple.Adventurer;

/**
 * Created by jasonchang on 2017/4/21.
 * 模式名：工廠方法模式
 * 模式解說：一個工廠只生產一個產品，子類工廠生產相對應的子類產品
 * 範例解說：弓箭手訓練營，訓練弓箭手，騎士訓練營，訓練騎士
 * Insight: The purpose of factory design patter is to encapsulate the new() function into implementing child class.
 * And the interface provide the core logic to do the business. This way can decouple the client logic and implementation logic.
 * In SOLID principles, the factory is the O. Open/close principle. Open for extending, but close for modification.
 */
public class MainClient {
    public static void main(String[] args) {
        ITrainingCamp trainingCamp = new ArcherTrainingCamp();
        Adventurer adventurer = trainingCamp.trainAdventurer();
        System.out.println(adventurer.getType());

        trainingCamp = new KnightTrainingCamp();
        adventurer = trainingCamp.trainAdventurer();
        System.out.println(adventurer.getType());
    }
}
