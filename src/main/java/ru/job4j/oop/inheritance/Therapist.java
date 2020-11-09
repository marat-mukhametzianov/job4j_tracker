package ru.job4j.oop.inheritance;

public class Therapist extends Doctor {
    private String advice;

    public String getAdvice() {return advice;}

    public void giveAdvice(byte experience) {
        if (experience > 0) {
            advice = "Useful";
        } else {
            advice = "Useless";
        }
    }
}
