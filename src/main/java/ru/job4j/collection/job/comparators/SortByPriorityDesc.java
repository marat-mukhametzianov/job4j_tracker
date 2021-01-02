package ru.job4j.collection.job.comparators;

import ru.job4j.collection.job.Job;

import java.util.Comparator;

public class SortByPriorityDesc implements Comparator<Job> {

    @Override
    public int compare(Job two, Job one) {
        return Integer.compare(one.getPriority(), two.getPriority());
    }
}
