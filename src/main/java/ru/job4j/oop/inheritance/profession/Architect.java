package ru.job4j.oop.inheritance.profession;

public class Architect extends Engineer {
    private boolean result;

    public boolean checkResult() {return result;}

    private void buidlHoues(byte houseQuantity) {
        if (houseQuantity != 0) {
            result = true;
        }
    }
}
