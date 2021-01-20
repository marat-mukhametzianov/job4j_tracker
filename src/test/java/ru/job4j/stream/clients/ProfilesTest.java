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
                new Address(
                        "New York",
                        "1st avenue",
                        700,
                        1
                ),
                new Address(
                        "Philadelphia",
                        "Sanford",
                        700,
                        4
                )
        );
        profiles.add(new Profile(addresses.get(0)));
        profiles.add(new Profile(addresses.get(1)));
    }

    @Test
    public void collect() {
        Function<Profile, Address> rule = profile -> profile.getAddress();
        List<Address> result = new Profiles().collect(profiles, rule);
        assertThat(result, is(addresses));
    }
}