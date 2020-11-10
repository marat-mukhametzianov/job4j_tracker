package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
//        Item item = new Item();
//        LocalDateTime created = item.getCreated();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
//        String formatedCreated = created.format(formatter);
//        System.out.println(formatedCreated);
        System.out.println(new Item(273, "Paradox"));
    }
}
