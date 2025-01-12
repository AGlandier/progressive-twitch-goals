package com.ksomon.progressive.goals.action;

import javax.swing.*;
import java.io.IOException;

public class DisposeFrameAction implements Action {

    private final JFrame frameToClose;

    public DisposeFrameAction(JFrame frameToClose) {
        this.frameToClose = frameToClose;
    }

    @Override
    public void execute() throws IOException {
        frameToClose.dispose();
    }
}
