package ru.job4j.search;

import java.util.LinkedList;

public class PriorityLine {
    private LinkedList<Task> tasks = new LinkedList<Task>();

    /**
     * The method has to place an element at specific position.
     * The position is determined by the priority field.
     * @param task is an object to add.
     */
    public void put (Task task) {
        int index = 0;
        for (Task item : tasks) {
            if (task.getPriority() < item.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    public Task take () {
        return tasks.poll();
    }

}
