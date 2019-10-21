package com.jason.app.command;

/**
 * Created by jasonchang on 2017/5/3.
 */
public class BackendCommand implements Command{
    private Receiver receiver;

    public BackendCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.backendWriteApi();
    }
}
