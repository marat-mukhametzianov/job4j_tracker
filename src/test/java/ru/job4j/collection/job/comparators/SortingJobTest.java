package ru.job4j.collection.job.comparators;

import org.junit.Test;
import ru.job4j.collection.job.Job;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortingJobTest {

    @Test
    public void compareByNameAsc() {
        List<Job> jobs = Arrays.asList(new Job("three", 3), new Job("one", 1), new Job("two", 2));
        jobs.sort(new SortByNameAsc());
        assertThat(jobs.get(0).getName(), is("one"));
    }

    @Test
    public void compareByNameAscReversed() {
        List<Job> jobs = Arrays.asList(new Job("three", 3), new Job("one", 1), new Job("two", 2));
        jobs.sort(new SortByNameAsc().reversed());
        assertThat(jobs.get(0).getName(), is("two"));
    }

    @Test
    public void compareByNameDesc() {
        List<Job> jobs = Arrays.asList(new Job("three", 3), new Job("one", 1), new Job("two", 2));
        jobs.sort(new SortByNameDesc());
        assertThat(jobs.get(0).getName(), is("two"));
    }

    @Test
    public void compareByNameDescReversed() {
        List<Job> jobs = Arrays.asList(new Job("three", 3), new Job("one", 1), new Job("two", 2));
        jobs.sort(new SortByNameDesc().reversed());
        assertThat(jobs.get(0).getName(), is("one"));
    }

    @Test
    public void compareByPriorityAsc() {
        List<Job> jobs = Arrays.asList(new Job("three", 3), new Job("one", 1), new Job("two", 2));
        jobs.sort(new SortByPriorityAsc());
        assertThat(jobs.get(0).getPriority(),is(1));
    }

    @Test
    public void compareByPriorityAscReversed() {
        List<Job> jobs = Arrays.asList(new Job("three", 3), new Job("one", 1), new Job("two", 2));
        jobs.sort(new SortByPriorityAsc().reversed());
        assertThat(jobs.get(0).getPriority(),is(3));
    }

    @Test
    public void compareByPriorityDesc() {
        List<Job> jobs = Arrays.asList(new Job("three", 3), new Job("one", 1), new Job("two", 2));
        jobs.sort(new SortByPriorityDesc());
        assertThat(jobs.get(0).getPriority(),is(3));
    }

    @Test
    public void compareByPriorityDescReversed() {
        List<Job> jobs = Arrays.asList(new Job("three", 3), new Job("one", 1), new Job("two", 2));
        jobs.sort(new SortByPriorityDesc().reversed());
        assertThat(jobs.get(0).getPriority(),is(1));
    }

    @Test
    public void compareAscNameAscPriority() {
        List<Job> jobs = Arrays.asList(new Job("two", 3), new Job("one", 1), new Job("two", 2));
        assertThat(complexSorting(new SortByNameAsc(), new SortByPriorityAsc(), jobs).get(2), is(new Job("two", 3)));
    }

    @Test
    public void compareAscNameDescPriority() {
        List<Job> jobs = Arrays.asList(new Job("two", 3), new Job("one", 1), new Job("two", 2));
        assertThat(complexSorting(new SortByNameAsc(), new SortByPriorityDesc(), jobs).get(2), is(new Job("two", 2)));
    }

    @Test
    public void compareDescNameAscPriority() {
        List<Job> jobs = Arrays.asList(new Job("two", 3), new Job("one", 1), new Job("two", 2));
        assertThat(complexSorting(new SortByNameDesc(), new SortByPriorityAsc(), jobs).get(0), is(new Job("two", 2)));
    }

    @Test
    public void compareDescNameDescPriority() {
        List<Job> jobs = Arrays.asList(new Job("two", 3), new Job("one", 1), new Job("two", 2));
        assertThat(complexSorting(new SortByNameDesc(), new SortByPriorityDesc(), jobs).get(0), is(new Job("two", 3)));
    }

    @Test
    public void compareDescNameAscPriorityReversedControl() {
        List<Job> jobs = Arrays.asList(new Job("two", 3), new Job("one", 1), new Job("two", 2));
        assertThat(complexSorting(new SortByNameDesc(), new SortByPriorityAsc().reversed(), jobs).get(0), is(new Job("two", 3)));
    }

    private List<Job> complexSorting(Comparator one, Comparator two, List<Job> list) {
        Comparator complex = one.thenComparing(two);
        list.sort(complex);
        return list;
    }
}