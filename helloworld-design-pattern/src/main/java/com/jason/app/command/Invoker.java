package com.jason.app.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonchang on 2017/5/3.
 */
public class Invoker {
    /**
     * 命令佇列
     */
    private List<Command> commandList = new ArrayList<>();

    /**
     * 增加命令
     * @param command
     */
    public void addCommand(Command command){
        commandList.add(command);
    }

    /**
     * 執行命令
     */
    public void executeCommand(){
        for (Command command:commandList){
            command.execute();
        }
    }
}
