package com.jason.app.command;

/**
 * Created by jasonchang on 2017/5/3.
 * 模式名：命令模式
 * 模式解說：將命令、執行命令者（接受者）、請求命令者，三者解耦，使得請求命令者，可以開放更多的功能給客戶，如命令佇列、命令撤銷
 * 範例解說：此範例為網站設計公司，董事長為客戶，Invoker為秘書，Receiver為執行團隊，董事長要求多個命令，秘書接收到後，將這些命令執行，
 * 而命令早已綁定執行者，所以會依照命令的執行者而執行。
 */
public class Client {
    public static void main(String[] args) {
        // 執行工作的每個員工（實際執行者）
        Receiver receiver = new Receiver();

        // 董事長交待的命令（各部門命令）
        Command designCommand = new DesignCommand(receiver);
        Command backendCommand = new BackendCommand(receiver);
        Command frontendCommand = new FrontendCommand(receiver);

        // 秘書（命令接收者）
        Invoker invoker = new Invoker();

        System.out.println("董事長跟秘書說：需要一個網站，全部部門動起來");
        invoker.addCommand(designCommand);
        invoker.addCommand(backendCommand);
        invoker.addCommand(frontendCommand);

        System.out.println("董事長跟秘書說：再接著還要修改一個舊網站，需要後端與前端的栛助");
        invoker.addCommand(backendCommand);
        invoker.addCommand(frontendCommand);

        System.out.println("秘書收到，轉達各部門主管，開始動工");
        invoker.executeCommand();
    }
}
