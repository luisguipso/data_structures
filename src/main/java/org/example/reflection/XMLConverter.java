package org.example.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class XMLConverter {

    public static final String LINE_BREAK = "\n";

    public String convert(Object o) throws IllegalAccessException {
        String className = o.getClass().getSimpleName().toLowerCase();
        String fields = convertFields(o);
        return openTag(className) + "\n" + fields + closeTag(className);
    }

    private String convertFields(Object o) throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        List<String> javaTypes = Arrays.asList("int", "long", "float", "double", "boolean", "char", "string");
        for (Field each : o.getClass().getDeclaredFields()) {
            if (!each.canAccess(o))
                each.trySetAccessible();
            String attributeName = each.getName();
            if (!javaTypes.contains(each.getType().getSimpleName().toLowerCase()))
                builder.append(convert(each.get(o)))
                        .append(LINE_BREAK);
            else
                builder.append(openTag(attributeName))
                       .append(each.get(o))
                       .append(closeTag(attributeName))
                       .append(LINE_BREAK);

        }
        return builder.toString();
    }

    private String openTag(String tagName) {
        return "<" + tagName + ">";
    }

    private String closeTag(String tagName) {
        return "</" + tagName + ">";
    }
}