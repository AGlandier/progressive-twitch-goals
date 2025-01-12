package com.ksomon.progressive.goals.parser;

import com.ksomon.progressive.goals.model.Goal;

import java.util.List;
import java.util.Map;

public class GoalParser {

    public Goal parse(Map<String, Integer> headers, List<String> values) {
        final Goal result = new Goal();

        result.setName(ParseUtils.parse(headers, values, "name"));
        result.setAmount(ParseUtils.parseInt(headers, values, "amount"));

        return result;
    }
}
