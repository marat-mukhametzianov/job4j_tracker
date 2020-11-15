package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("Test item");
        tracker.add(item);
        Item item1 = new Item();
        item1.setName("item1");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("item2");
        tracker.add(item2);
        System.out.println(tracker.findById(1));
        tracker.delete(1);
        tracker.delete(2);
        tracker.delete(3);
    }
}
