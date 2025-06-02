package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        String newLine = System.lineSeparator();
        return "{" + newLine + "\t\"name\" : " + "\"" + name + "\","
                + newLine + "\t\"body\" : " + "\"" + body + "\"" + newLine + "}";
    }
}
