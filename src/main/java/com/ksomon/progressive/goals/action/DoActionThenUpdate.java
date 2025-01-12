package com.ksomon.progressive.goals.action;

import javax.swing.*;
import java.io.IOException;

public class DoActionThenUpdate implements Action{

    private final Action firstAction;
    private final JFrame frameToUpdate;
    private final Object lock = new Object();


    public DoActionThenUpdate(Action firstAction, JFrame frameToUpdate) {
        this.firstAction = firstAction;
        this.frameToUpdate = frameToUpdate;
    }

    @Override
    public void execute() throws IOException {

        synchronized (this.lock) {
            firstAction.execute();
        }

        frameToUpdate.invalidate();
        frameToUpdate.validate();
        frameToUpdate.repaint();
    }
}
