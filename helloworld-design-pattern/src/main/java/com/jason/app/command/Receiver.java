package com.jason.app.command;

/**
 * Created by jasonchang on 2017/5/3.
 * 命令執行者
 */
public class Receiver {
    /**
     * 後端部門寫API
     */
    public void backendWriteApi() {
        System.out.println("後端部門：開始寫API…");
    }

    /**
     * 前端部門套版串API
     */
    public void frontendWriteView() {
        System.out.println("前端部門：開始切版與串後端API寫功能…");
    }

    /**
     * 設計部門負責設計畫面與元件等等
     */
    public void design() {
        System.out.println("設計部門：開始設計各元件與顯示畫面…");
    }
}
