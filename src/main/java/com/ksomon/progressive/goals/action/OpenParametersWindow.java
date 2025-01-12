package com.ksomon.progressive.goals.action;

import com.ksomon.progressive.goals.ParametersWindow;

import java.io.IOException;

public class OpenParametersWindow implements Action {

    @Override
    public void execute() throws IOException {
        new ParametersWindow();
    }
}
