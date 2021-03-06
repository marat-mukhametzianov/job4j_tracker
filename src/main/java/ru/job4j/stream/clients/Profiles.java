package ru.job4j.stream.clients;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect (List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList());
    }

    public List<Address> arrangeAndDistinct(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .sorted(((o1, o2) -> o1.getCity().compareTo(o2.getCity())))
                .distinct()
                .collect(Collectors.toList());
    }
}