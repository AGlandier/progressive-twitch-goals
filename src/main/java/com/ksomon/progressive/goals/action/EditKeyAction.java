package com.ksomon.progressive.goals.action;

import com.ksomon.progressive.goals.ParametersHandler;
import com.ksomon.progressive.goals.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class EditKeyAction implements Action{

    private final JTextField fieldToUpdate;
    private final String paramName;

    public EditKeyAction(JTextField fieldToUpdate, String paramName) {
        this.fieldToUpdate = fieldToUpdate;
        this.paramName = paramName;
    }

    @Override
    public void execute() {

        JFrame editFrame = new JFrame();
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editFrame.setSize(100,60);
        editFrame.setLayout(new BorderLayout());
        editFrame.setLocationRelativeTo(null);
        editFrame.setResizable(false);
        editFrame.setVisible(true);

        JPanel editPanel = new JPanel();
        editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.PAGE_AXIS));
        editPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        editPanel.add(UIUtils.buildLabel("Press any key"));

        editFrame.add(editPanel);

        editFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                int keyCode = event.getKeyCode();
                try {
                    ParametersHandler.getInstance("").setParam(paramName, Integer.toString(keyCode));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                editFrame.dispose();
                fieldToUpdate.setText(UIUtils.getKeyName(keyCode));
            }
        });
    }


}
