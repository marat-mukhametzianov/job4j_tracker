package ru.job4j.ex;

import java.util.Scanner;

public class FindAll {

    public static void main(String[] args) {
        String[] strings = {"One", "Two"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a key word:");
        String key = scanner.nextLine();
        try {
            int result = indexOf(strings, key);
            System.out.println(result);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for(int i = 0; i < value.length; i++) {
            if(value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("There is no such element in the given array.");
        }
        return result;
    }
}