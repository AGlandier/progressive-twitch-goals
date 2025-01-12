package com.ksomon.progressive.goals;

import com.ksomon.progressive.goals.action.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

import static com.ksomon.progressive.goals.UIUtils.*;

public class MainWindow {

    public MainWindow() throws IOException {

        JFrame frame = buildWindow();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buildControlPanel(), buildSetUpPanel());
        splitPane.setDividerLocation(200 + splitPane.getInsets().left);
        frame.add(splitPane);
    }

    /**
     * Configures the main window of the app
     * @return JFrame object
     */
    private JFrame buildWindow() {
        JFrame frame = new JFrame("ProgessiveGoals - By Ksomon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        frame.setSize(new Dimension(400, 300));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }

    /**
     * Builds the panel used to control the text to display on OBS
     * @return JPanel object
     */
    private JPanel buildControlPanel() throws IOException {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));

        JLabel label = buildLabel(UIUtils.readTextToDisplay());
        JButton plusButton = buildCenteredButton("+", new IncreaseCounterAction(label));
        JButton minusButton = buildCenteredButton("-", new DecreaseCounterAction(label));

        controlPanel.add(plusButton);
        controlPanel.add(label);
        controlPanel.add(minusButton);



        return controlPanel;
    }

    /**
     * Builds the panel used to actions that not directly interacts with the text to display on OBS
     * @return
     */
    private JPanel buildSetUpPanel() {
        JPanel setUpPanel = new JPanel();
        setUpPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        setUpPanel.setLayout(new BoxLayout(setUpPanel, BoxLayout.PAGE_AXIS));

        setUpPanel.add(buildCenteredButton("Open Folder", new OpenFolderAction()));
        setUpPanel.add(buildCenteredButton("Parameters", new OpenParametersWindow()));

        return setUpPanel;
    }
}
