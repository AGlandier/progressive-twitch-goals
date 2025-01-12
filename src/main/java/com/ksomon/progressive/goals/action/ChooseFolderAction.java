package com.ksomon.progressive.goals.action;

import com.ksomon.progressive.goals.ParametersHandler;

import javax.swing.*;
import java.io.IOException;

public class ChooseFolderAction implements Action{

    private final JPanel parentPanel;
    private final JTextField fieldToUpdate;

    public ChooseFolderAction(JPanel parentPanel, JTextField fieldToUpdate) {
        this.parentPanel = parentPanel;
        this.fieldToUpdate = fieldToUpdate;
    }

    @Override
    public void execute() throws IOException {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(parentPanel);
        if (option == JFileChooser.APPROVE_OPTION) {
            String newPath = fileChooser.getSelectedFile().getAbsolutePath();
            ParametersHandler.getInstance("").setParam(ParametersHandler.FOLDER, newPath);
            fieldToUpdate.setText(newPath);
        }
    }
}
