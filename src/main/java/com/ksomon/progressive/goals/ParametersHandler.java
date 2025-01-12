package com.ksomon.progressive.goals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ParametersHandler {

    private static ParametersHandler instance;
    private String path;

    private ParametersHandler(String path) {
        this.path = path;
    }

    public static ParametersHandler getInstance(String path) {
        if (instance == null) {
            instance = new ParametersHandler(path);
        }
        return instance;
    }

    public Map<String, String> getParameters() throws IOException {
        if (instance == null) {
            throw new IllegalStateException("Instance of ParametersHandler has not been initialized");
        }

        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get(this.path)));

        Map<String, String> result = new HashMap<>();

        for (String property : properties.stringPropertyNames()) {
            result.put(property, properties.getProperty(property));
        }

        return result;
    }

    public void setParam(String paramName, String newValue) throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(this.path);
        properties.load(fis);

        properties.setProperty(paramName,newValue);

        FileOutputStream fos = new FileOutputStream(this.path);
        properties.store(fos,null);

    }

    public static String FOLDER = "BASE.DIR";
    public static String INCREASE_KEY = "INCREASE.KEY";
    public static String DECREASE_KEY = "DECREASE.KEY";
    public static String CURRENT_COUNT = "CURRENT.COUNT";

}
