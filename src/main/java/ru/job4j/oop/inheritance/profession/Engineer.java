package ru.job4j.oop.inheritance.profession;

public class Engineer extends Profession {
    private String report;

    public String getReport() {
        return report;
    }

    public void writeReport(float someData) {
        if (someData > 0) {
            this.report = "Positive";
        } else {
            this.report = "Negative";
        }
    }
}
