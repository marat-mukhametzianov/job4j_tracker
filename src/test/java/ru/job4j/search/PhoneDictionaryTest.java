package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person(
                "Petr",
                "Arsentev",
                "Bryansk",
                "534872")
        );
        assertThat(
                phoneDictionary.find("Bryansk").get(0).getSurname(),
                is("Arsentev")
        );
    }
}