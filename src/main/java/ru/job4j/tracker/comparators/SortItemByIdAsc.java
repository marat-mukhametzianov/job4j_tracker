package ru.job4j.tracker.comparators;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortItemByIdAsc implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        int result;
        int firstId = o1.getId();
        int secondId = o2.getId();
        if (firstId == secondId) {
            result = 0;
        }
        result = firstId < secondId ? -1 : 1;
        return result;
    }
}
