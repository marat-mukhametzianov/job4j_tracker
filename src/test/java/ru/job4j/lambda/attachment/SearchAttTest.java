package ru.job4j.lambda.attachment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchAttTest {

    @Test
    public void universalFilterSize() {
        List<Attachment> input = Arrays.asList(
                new Attachment("One", 50),
                new Attachment("Two", 100),
                new Attachment("Three", 101)
        );
        List<Attachment> output = SearchAtt.filterSize(input);
        assertThat(output.get(0).getName(), is("Three"));
    }

    @Test
    public void universalFilterName() {
        List<Attachment> input = Arrays.asList(
                new Attachment("One", 50),
                new Attachment("bug", 100),
                new Attachment("bug", 101)
        );
        List<Attachment> output = SearchAtt.filterName(input);
        assertThat(output.size(), is(2));
    }
}