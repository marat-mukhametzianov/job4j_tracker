package ru.job4j.collection.job.comparators;

import ru.job4j.collection.job.Job;

import java.util.Comparator;

public class SortByNameDesc implements Comparator<Job> {

    @Override
    public int compare(Job one, Job two) {
        return two.getName().compareTo(one.getName());
    }
}
