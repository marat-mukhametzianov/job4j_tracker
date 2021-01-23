package ru.job4j.stream;

import java.util.stream.Stream;

enum Suit {
    diamonds, hearts, spades, clubs
}

enum Value {
    v_6, v_7, v_8, v_9, v_10, jack, queen, king, ace
}

class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }
}

public class Cards {
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(
                        suit -> Stream.of(Value.values())
                                .map(value -> new Card(suit, value))
                )
                .forEach(e -> System.out.println(e));
    }
}


