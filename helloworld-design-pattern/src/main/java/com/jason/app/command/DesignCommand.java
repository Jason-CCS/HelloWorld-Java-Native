package com.jason.app.command;

/**
 * Created by jasonchang on 2017/5/3.
 */
public class DesignCommand implements Command {
    private Receiver receiver;

    public DesignCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.design();
    }
}
