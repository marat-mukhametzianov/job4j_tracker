package ru.job4j.lambda;

import org.junit.Test;
import ru.job4j.lambda.attachment.Attachment;
import ru.job4j.lambda.attachment.SearchAtt;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchAttTest {

    @Test
    public void universalFilterSize() {
        List<Attachment> input = List.of(
                new Attachment("One", 50),
                new Attachment("Two", 100),
                new Attachment("Three", 101)
        );
        List<Attachment> output = SearchAtt.filterSize(input);
        assertThat(output.get(0).getName(), is("Three"));
    }

    @Test
    public void universalFilterName() {
        List<Attachment> input = List.of(
                new Attachment("One", 50),
                new Attachment("bug", 100),
                new Attachment("bug", 101)
        );
        List<Attachment> output = SearchAtt.filterName(input);
        assertThat(output.size(), is(2));
    }
}