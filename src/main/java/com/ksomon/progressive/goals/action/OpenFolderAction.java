package com.ksomon.progressive.goals.action;

import com.ksomon.progressive.goals.ParametersHandler;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OpenFolderAction implements Action{

    @Override
    public void execute() throws IOException {
        Desktop.getDesktop().open(new File(ParametersHandler.getInstance("").getParameters().get(ParametersHandler.FOLDER)));
    }
}
