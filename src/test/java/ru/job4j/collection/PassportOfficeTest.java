package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void addPositive() {
        PassportOffice passportOffice = new PassportOffice();
        Citizen citizen = new Citizen("12345", "John Smith");
        assertTrue(passportOffice.add(citizen));
    }

    @Test
    public void addNegative() {
        PassportOffice passportOffice = new PassportOffice();
        Citizen citizen = new Citizen("12345", "John Smith");
        Citizen additionalCitizen = new Citizen("12345", "Mary McDonald's");
        passportOffice.add(citizen);
        assertFalse(passportOffice.add(additionalCitizen));
    }

    @Test
    public void getReceiveValue() {
        PassportOffice passportOffice = new PassportOffice();
        Citizen citizen = new Citizen("12345", "John Smith");
        passportOffice.add(citizen);
        assertThat(passportOffice.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void getReceiveNull() {
        PassportOffice passportOffice = new PassportOffice();
        Citizen citizen = new Citizen("12345", "John Smith");
        passportOffice.add(citizen);
        assertNull(passportOffice.get("test"));
    }
}