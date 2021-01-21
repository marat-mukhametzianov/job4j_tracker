package ru.job4j.stream.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Profile> profiles = new ArrayList<>();
    private List<Address> addresses = new ArrayList<>();

    @Before
    public void setup() {
        addresses = List.of(
                new Address("Washington", "Lincoln", 1, 1),
                new Address("New York", "1st avenue", 700, 1),
                new Address("Philadelphia", "Sanford", 700, 4),
                new Address("New York", "1st avenue", 700, 1),
                new Address("Philadelphia", "Sanford", 700, 4),
                new Address("New York", "1st avenue", 700, 1)
        );
        for (Address item : addresses) {
            profiles.add(new Profile(item));
        }
    }

    @Test
    public void collect() {
        List<Address> result = new Profiles().arrangeAndDistinct(profiles);
        List<Address> expected = List.of(
                new Address("New York", "1st avenue", 700, 1),
                new Address("Philadelphia", "Sanford", 700, 4),
                new Address("Washington", "Lincoln", 1, 1)
        );
        assertThat(result, is(expected));
    }
}