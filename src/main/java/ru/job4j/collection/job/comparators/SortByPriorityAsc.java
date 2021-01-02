package ru.job4j.collection.job.comparators;

import ru.job4j.collection.job.Job;

import java.util.Comparator;

public class SortByPriorityAsc implements Comparator<Job> {

    @Override
    public int compare(Job one, Job two) {
        return Integer.compare(one.getPriority(), two.getPriority());
    }
}
