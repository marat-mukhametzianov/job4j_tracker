package ru.job4j.tracker;

import java.util.Arrays;

public class TrackerSingleThree {
    private static final TrackerSingleThree INSTANCE = new TrackerSingleThree();
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private TrackerSingleThree() { }

    public static TrackerSingleThree getINSTANCE() {
        return INSTANCE;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     * The method returns a copy of the items array, but with no null elements
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        short index = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[index++] = items[i];
            }
        }
        return Arrays.copyOf(result, index);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items[index] = item;
            items[index].setId(id);
        }
        return result;
    }

    private int indexOf(int id) {
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            --size;
        }
        return result;
    }
}
