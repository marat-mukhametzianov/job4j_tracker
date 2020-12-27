package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = new ArrayList<>(Arrays.asList(new Account("1 10 1000", "John M.", "100"), new Account("2 20 200", "John M.", "100")));
        HashSet<Account> expected = new HashSet<>(Arrays.asList(new Account("1 10 1000", "John M.", "100"), new Account("2 20 200", "John M.", "100")));
        assertThat(NotifyAccount.sent(accounts), is(expected));
    }
}