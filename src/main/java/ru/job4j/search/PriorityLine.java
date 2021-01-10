package ru.job4j.search;

import java.util.LinkedList;

/**
 * This class designation is creating a LinkedList of Task elements, and taking its first element.
 * @author Marat. M.
 * @version 1.0.
 */
public class PriorityLine {
    private LinkedList<Task> tasks = new LinkedList<Task>();

    /**
     * This method creates a LinkedList of Task elements according to their priorities.
     * The priority of the received task is compared to the priority of each existing element.
     * In case of the received task priority is less than the existing one, the value of the index
     * is considered achieved. Then received task placed at the index position.
     * @param task is an instance of the Task class, and is going to be added into LinkedList.
     */
    public void put(Task task) {
        int index = 0;
        for (Task item : tasks) {
            if (task.getPriority() < item.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * The method returns the first element of the LinkedList, removing it from the list.
     * @return is the first element of the LinkedList, or the null if the list is empty.
     */
    public Task take() {
        return tasks.poll();
    }

}
