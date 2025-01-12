package com.ksomon.progressive.goals;

import com.ksomon.progressive.goals.action.ChooseFolderAction;
import com.ksomon.progressive.goals.action.DisposeFrameAction;
import com.ksomon.progressive.goals.action.EditKeyAction;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ParametersWindow {

    private JFrame frame;

    public ParametersWindow() throws IOException {
        JFrame paramWindow = buildWindow();
        this.frame = paramWindow;
        paramWindow.add(buildPanel());
    }

    /**
     * Configures the parameters window of the app
     * @return JFrame object
     */
    private JFrame buildWindow() throws IOException {
        JFrame frame = new JFrame("Parameters");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.setSize(new Dimension(400, 300));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        return frame;
    }

    /**
     * Builds the objects to display on the window and places them in a planel
     * @return JPanel object
     */
    private JPanel buildPanel () throws IOException {
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JTextField folderField = UIUtils.buildField(ParametersHandler.getInstance("").getParameters().get(ParametersHandler.FOLDER), false);
        panel.add(UIUtils.buildLeftButton("Change folder", new ChooseFolderAction(panel, folderField)));
        panel.add(folderField);

        int increaseKeyCode = Integer.parseInt(ParametersHandler.getInstance("").getParameters().get(ParametersHandler.INCREASE_KEY));
        JTextField increaseField = UIUtils.buildField(UIUtils.getKeyName(increaseKeyCode), false);

        JButton editIncreaseButton = UIUtils.buildLeftButton("Edit INCREASE key", new EditKeyAction(increaseField, ParametersHandler.INCREASE_KEY));
        editIncreaseButton.setEnabled(false);
        panel.add(editIncreaseButton);

        panel.add(increaseField);

        int decreaseKeyCode = Integer.parseInt(ParametersHandler.getInstance("").getParameters().get(ParametersHandler.DECREASE_KEY));
        JTextField decreaseField = UIUtils.buildField(UIUtils.getKeyName(decreaseKeyCode), false);

        JButton editDecreaseButton = UIUtils.buildLeftButton("Edit DECREASE key", new EditKeyAction(decreaseField,ParametersHandler.DECREASE_KEY));
        editDecreaseButton.setEnabled(false);
        panel.add(editDecreaseButton);
        panel.add(decreaseField);

        panel.add(UIUtils.buildLeftButton("Back", new DisposeFrameAction(this.frame)));

        return panel;
    }

}
