package org.example.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class XMLConverter {

    public static final String LINE_BREAK = "\n";
    private StringBuilder builder;

    public String convert(Object o) throws IllegalAccessException {
        convertClass(o);
        return builder.toString();
    }

    private void convertClass(Object o) throws IllegalAccessException {
        String className = o.getClass().getSimpleName().toLowerCase();
        builder.append(openTag(className)).append(LINE_BREAK);
        convertClassFields(o);
        builder.append(closeTag(className));
    }

    private void convertClassFields(Object o) throws IllegalAccessException {
        List<String> javaTypes = Arrays.asList("int", "long", "float", "double", "boolean", "char", "string");
        for (Field each : o.getClass().getDeclaredFields()) {
            convertField(o, javaTypes, each);
        }
    }

    private void convertField(Object o, List<String> javaTypes, Field each) throws IllegalAccessException {
        if (!each.canAccess(o))
            each.trySetAccessible();
        if (!javaTypes.contains(each.getType().getSimpleName().toLowerCase()))
            builder.append(convert(each.get(o)));
        else
            appendJavaType(o, each);
        builder.append(LINE_BREAK);
    }

    private void appendJavaType(Object o, Field each) throws IllegalAccessException {
        String attributeName = each.getName();
        builder.append(openTag(attributeName))
                .append(each.get(o))
                .append(closeTag(attributeName));
    }

    private String openTag(String tagName) {
        return "<" + tagName + ">";
    }

    private String closeTag(String tagName) {
        return "</" + tagName + ">";
    }
}
