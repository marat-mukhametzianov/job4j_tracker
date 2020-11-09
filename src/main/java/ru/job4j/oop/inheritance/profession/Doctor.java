package ru.job4j.oop.inheritance.profession;

public class Doctor extends Profession {
    private String anamnesis;

    public String getAnamnesis() {return anamnesis;}

    public void collectAnamnesis(String patientStory) {
        this.anamnesis = patientStory;
    }
}
