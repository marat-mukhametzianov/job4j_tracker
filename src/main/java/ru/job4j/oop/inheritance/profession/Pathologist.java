package ru.job4j.oop.inheritance.profession;

public class Pathologist extends Doctor {
    private byte corpseADay;

    public byte getCorpseADay() {
        return corpseADay;
    }

    public void gutACorpse(byte corpseNumber) {
        corpseADay = corpseNumber;
    }
}
