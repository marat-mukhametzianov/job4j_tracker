package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println("Pussy " + this.name + " ate " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveName(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveName("Gav");
        gav.eat("Hamburger.");
        System.out.println("There is gav's food.");
        gav.show();
        Cat black = new Cat();
        black.giveName("Black");
        black.eat("Fish.");
        System.out.println("There is black's food.");
        black.show();
    }

    public String sound() {
        String voice = "may-may";
        return voice;
    }
}
