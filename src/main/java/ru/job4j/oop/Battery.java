package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int charge) {
        this.load = charge;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery firstBattery = new Battery(11);
        Battery secondBattery = new Battery(9);
        System.out.println("Initial state: first battery charge is " + firstBattery.load
                +
                ", second battery is - " + secondBattery.load);
        secondBattery.exchange(firstBattery);
        System.out.println("Afterwards state: first battery charge is " + firstBattery.load
                + ", second battery is - " + secondBattery.load);
    }
}
