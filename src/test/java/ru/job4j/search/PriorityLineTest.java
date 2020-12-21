package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PriorityLineTest {
    @Test
    public void whenTakeTheHighestPriority() {
        PriorityLine priorityLine = new PriorityLine();
        priorityLine.put(new Task("low", 5));
        priorityLine.put(new Task("urgent", 2));
        priorityLine.put(new Task("middle", 3));
        Task takenTask = priorityLine.take();
        assertThat(takenTask.getDescription(), is("urgent"));
    }
}