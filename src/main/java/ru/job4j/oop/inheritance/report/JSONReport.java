package ru.job4j.oop.inheritance.report;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        return "{" + System.lineSeparator()
                +
                "\tname : " + name + "," + System.lineSeparator()
                +
                "\tbody : " + body + System.lineSeparator()
                +
                "}";
    }
}
