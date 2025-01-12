package com.ksomon.progressive.goals;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            ParametersHandler.getInstance("goals-params.properties");
            startApp();
        } else if (args.length == 1) {

            String path = args[0];
            String completePath;
            if (path.endsWith("\\") || path.endsWith("/")) {
                completePath = path + "goals-params.properties";
            } else {
                completePath = path + "\\goals-params.properties";
            }

            File paramsFile = new File(completePath);

            if (paramsFile.canRead()) {
                ParametersHandler.getInstance(completePath);
                ParametersHandler.getInstance("").getParameters();
                startApp();
            } else {
                System.out.printf("Can't open %s file", completePath);
            }

        } else {
            System.out.print("Too much arguments (try -> ProgressiveGoals.jar path-to-params-folder)");
        }

    }

    private static void startApp() {
        SwingUtilities.invokeLater(() -> {
            try {
                new MainWindow();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
