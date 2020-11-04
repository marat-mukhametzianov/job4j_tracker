package ru.job4j.oop;

public class Jukebox {
    public static void main(String[] args) {
        Jukebox boombox = new Jukebox();
        for (int i = 2; i >= 0; i--) {
            boombox.music(i);
        }
    }

    public void music(int position) {
        String choice = "Песня не найдена";
        if (position == 1) {
            choice = "Пусть бегут неуклюже";
        }
        if (position == 2) {
            choice = "Спокойной ночи";
        }
        System.out.println(choice);
    }
}
