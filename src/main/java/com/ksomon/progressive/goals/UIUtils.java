package com.ksomon.progressive.goals;

import com.ksomon.progressive.goals.action.Action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UIUtils {


    /**
     * Builds a JButton object to display in a panel
     * @param name Label on the button
     * @param action Action to be performed when button is clicked
     * @return JButton object
     */
    private static JButton buildButton(String name, Action action) {
        JButton button = new JButton(name);

        button.setSize(new Dimension(100,25));
        if (action != null) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        action.execute();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }

        return button;
    }

    /**
     * Builds a JButton element to display centered in a panel
     * @param name Label on the button
     * @param action Action to be performed when button is clicked
     * @return JButton object
     */
    public static JButton buildCenteredButton (String name, Action action) {
        JButton button = buildButton(name, action);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    /**
     * Builds a JButton object to display left aligned in a panel
     * @param name Label on the button
     * @param action Action to be performed when button is clicked
     * @return JButton object
     */
    public static JButton buildLeftButton (String name, Action action) {
        JButton button = buildButton(name, action);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        return button;
    }

    /**
     * Builds a JLabel object to dsplay in a panel
     * @param displayed Text displayed on the label
     * @return JLabel object
     */
    public static JLabel buildLabel(String displayed) {

        JLabel label = new JLabel(displayed);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        return label;
    }

    /**
     * Builds a JTextField object to display in a panel
     * @param name Text to display in the field
     * @param enabled True if the text can be modified by user, false otherwise
     * @return JTextField object
     */
    public static JTextField buildField(String name, boolean enabled) {

        JTextField field = new JTextField(name);

        field.setAlignmentX(Component.LEFT_ALIGNMENT);
        field.setMaximumSize(new Dimension(1000,25));
        field.setEnabled(enabled);

        return field;
    }

    public static String getKeyName(int keyCode) {
        return KeyEvent.getKeyText(keyCode);
    }

    public static String readTextToDisplay() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ParametersHandler.getInstance("").getParameters().get(ParametersHandler.FOLDER) + "\\progressiveGoals_toDisplay.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        }
    }


}
