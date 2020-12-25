package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        for (Item element : items) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item element : items) {
            if (element.getName().equals(key)) {
                result.add(element);
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        for (Item element : items) {
            if (element.getId() == id) {
                item.setId(id);
                int index = items.indexOf(element);
                items.set(index, item);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        for (Item element : items) {
            if (element.getId() == id) {
                int index = items.indexOf(element);
                items.remove(index);
                result = true;
                break;
            }
        }
        return result;
    }
}