package com.jason.app.command;

/**
 * Created by jasonchang on 2017/5/3.
 */
public class FrontendCommand implements Command {
    private Receiver receiver;

    public FrontendCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.frontendWriteView();
    }
}
