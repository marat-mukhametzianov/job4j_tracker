package ru.job4j.collection;

public class Job implements Comparable<Job> {
    private String name;
    private int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "Job{" + System.lineSeparator() +
                    "\tname = " + name + System.lineSeparator() +
                    "\tpriority = " + priority + System.lineSeparator() +
                "}" + System.lineSeparator();
    }

    @Override
    public int compareTo(Job o) {
        return Integer.compare(priority, o.priority);
    }
}
