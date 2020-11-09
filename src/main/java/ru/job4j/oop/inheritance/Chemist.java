package ru.job4j.oop.inheritance;

public class Chemist extends Engineer {
    private boolean hasSpecialKnowledge;

    public boolean getLevel() {return hasSpecialKnowledge;}

    public void performWork(int data) {
        if (data != 0) {
            hasSpecialKnowledge = true;
        }
    }
}
