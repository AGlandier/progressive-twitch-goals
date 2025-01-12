package com.ksomon.progressive.goals.action;

import com.ksomon.progressive.goals.ParametersHandler;
import com.ksomon.progressive.goals.TextFileUpdater;
import com.ksomon.progressive.goals.UIUtils;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DecreaseCounterAction implements Action {

    private final JLabel labelToUpdate;
    private final TextFileUpdater fileUpdater;

    public DecreaseCounterAction(JLabel labelToUpdate) throws IOException {
        this.labelToUpdate = labelToUpdate;
        String path = ParametersHandler.getInstance("").getParameters().get(ParametersHandler.FOLDER);
        File textFile = new File(path + "\\progressiveGoals_toDisplay.txt");
        File csvFile = new File(path + "\\goals.csv");
        this.fileUpdater = new TextFileUpdater(textFile, csvFile);
    }

    @Override
    public void execute() throws IOException {
        Integer currentCount = Integer.parseInt(ParametersHandler.getInstance("").getParameters().get(ParametersHandler.CURRENT_COUNT));
        currentCount--;
        this.fileUpdater.updateTextToDisplay(currentCount);
        ParametersHandler.getInstance("").setParam(ParametersHandler.CURRENT_COUNT, currentCount.toString());
        labelToUpdate.setText(UIUtils.readTextToDisplay());
    }
}
