package com.ksomon.progressive.goals.parser;

import com.ksomon.progressive.goals.model.Goal;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoalsReader {

    private static  final String SEPARATOR = ";";
    private final File f;
    private final GoalParser parser;

    public GoalsReader(File f, GoalParser parser) {
        this.f = f;
        this.parser = parser;
    }

    public List<Goal> getAllGoals() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
        Map<String, Integer> headers = getHeaders(bufferedReader);

        List<Goal> result = new ArrayList<>();
        String line;

        while((line = bufferedReader.readLine()) != null) {
            result.add(getGoal(headers, line));
        }

        return result;
    }

    public Map<String, Integer> getHeaders() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
        Map<String, Integer> headers = new HashMap<>();
        String line;
        if ((line = bufferedReader.readLine()) != null) {
            final String[] values = line.split(SEPARATOR);
            for (int i = 0; i < values.length; i++) {
                headers.put(values[i], i);
            }
        }

        return headers;
    }

    private Map<String, Integer> getHeaders(BufferedReader bufferedReader) throws IOException {
        Map<String, Integer> headers = new HashMap<>();
        String line;
        if ((line = bufferedReader.readLine()) != null) {
            final String[] values = line.split(SEPARATOR);
            for (int i = 0; i < values.length; i++) {
                headers.put(values[i], i);
            }
        }
        return headers;
    }

    public Goal getGoal(final Map<String, Integer> headers, final String line) {
        final String[] values = line.split(SEPARATOR);
        final List<String> tokens = new ArrayList<>(values.length);
        for (int i = 0; i < values.length; i++) {
            tokens.add(values[i].trim());
        }
        return parser.parse(headers, tokens);
    }
}
