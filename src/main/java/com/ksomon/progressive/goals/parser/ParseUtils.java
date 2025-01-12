package com.ksomon.progressive.goals.parser;

import java.util.List;
import java.util.Map;

public class ParseUtils {

    public ParseUtils() {
    }

    public static String parse(Map<String, Integer> headers, List<String> values, String headerName) {
        final Integer index = headers.get(headerName);
        if (index == null) {
            throw  new IllegalArgumentException(String.format("L'indice de la colonne %s est introuvable", headerName));
        }
        return values.get(index);
    }

    public static Integer parseInt(Map<String, Integer> headers, List<String> values, String headerName) {
        final Integer index = headers.get(headerName);
        if (index == null) {
            throw  new IllegalArgumentException(String.format("L'indice de la colonne %s est introuvable", headerName));
        }
        return Integer.parseInt(values.get(index));
    }
}
