package ru.job4j.collection;

import java.util.Objects;

public class Citizen {
    private String passport;
    private String username;

    public Citizen(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Citizen citizen = (Citizen) o;
        return passport.equals(citizen.getPassport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
