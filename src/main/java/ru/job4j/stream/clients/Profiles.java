package ru.job4j.stream.clients;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect (
            List<Profile> profiles,
            Function<Profile, Address> rule
    ) {
        return profiles.stream()
                .map(rule)
                .collect(Collectors.toList());
    }
}
