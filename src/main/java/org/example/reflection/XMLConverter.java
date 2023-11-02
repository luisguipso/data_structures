package org.example.reflection;

import java.util.Arrays;

public class XMLConverter {
    public String convert(Object o){
        String className = o.getClass().getSimpleName().toLowerCase();
        String fields = Arrays.stream(o.getClass().getDeclaredFields()).map(each -> "    <" + each.getName() + ">" + "</" + each.getName() + ">\n").reduce(String::concat).orElse("");
        return "<"+className+">"+"\n"+ fields + "</"+className+">";
    }
}
