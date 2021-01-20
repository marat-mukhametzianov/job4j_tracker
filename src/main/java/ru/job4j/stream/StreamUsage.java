package ru.job4j.stream;

import java.util.List;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long scope;

        public Task(String name, long scope) {
            this.name = name;
            this.scope = scope;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.scope > 30)
                .map(task -> task.name + " " + task.scope)
                .forEach(System.out::println);
    }
}
