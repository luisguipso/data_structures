package org.example.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class XMLConverter {

    public static final String LINE_BREAK = "\n";
    private final StringBuilder builder;

    public XMLConverter() {
        builder = new StringBuilder();
    }

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
        for (Field each : o.getClass().getDeclaredFields()) {
            if (!each.canAccess(o))
                each.trySetAccessible();
            convertField(o, each);
        }
    }

    private void convertField(Object o, Field each) throws IllegalAccessException {
        if (isNotPrimitive(each))
            convert(each.get(o));
        else
            appendPrimitiveField(o, each);
        builder.append(LINE_BREAK);
    }

    private static boolean isNotPrimitive(Field each) {
        List<String> primitiveTypes = Arrays.asList("int", "long", "float", "double", "boolean", "char", "string");
        return !primitiveTypes.contains(each.getType().getSimpleName().toLowerCase());
    }

    private void appendPrimitiveField(Object o, Field each) throws IllegalAccessException {
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
