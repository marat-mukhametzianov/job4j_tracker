package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int selection = Integer.valueOf(scanner.nextInt());
            switch (selection) {
                case 0:
                    System.out.println("=== Creating a new item ====");
                    System.out.print("Enter name: \n");
                    String name = new Scanner(System.in).nextLine();
                    Item item = new Item(name);
                    item = tracker.add(item);
                    System.out.printf("Item has been added successfully.\n");
                    System.out.println(item);
                    break;
                case 1:
                    System.out.println("=== All available items ====");
                    Item[] items = tracker.findAll();
                    if (items.length > 0) {
                        for (Item element : items) {
                            System.out.println(element);
                        }
                    } else {
                        System.out.println("There are not available records.\n");
                    }
                    break;
                case 2:
                    System.out.println("Enter the edited item's ID:");
                    byte editedItemId = new Scanner(System.in).nextByte();
                    System.out.println("Enter new item's name:");
                    String editedItemName = new Scanner(System.in).nextLine();
                    Item editedItem = new Item(editedItemName);
                    if (tracker.replace(editedItemId, editedItem)) {
                        System.out.printf("The element with ID %d has been updated.\n", editedItemId);
                    } else {
                        System.out.println("Apparently, there is no element with the ID.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the deleted item's ID:");
                    byte removedItemId = new Scanner(System.in).nextByte();
                    if (tracker.delete(removedItemId)) {
                        System.out.printf("The element with ID %d has been deleted.\n", removedItemId);
                    } else {
                        System.out.println("Apparently, there is no element with the ID.");
                    }
                    break;
                case 4:
                    System.out.println("Enter the item's ID:");
                    byte foundItemId = new Scanner(System.in).nextByte();
                    Item foundItem = tracker.findById(foundItemId);
                    if (foundItem != null) {
                        System.out.println(foundItem);
                    } else {
                        System.out.println("Apparently, there is no element with the ID.");
                    }
                    break;
                case 5:
                    System.out.println("Enter the item's name:");
                    String foundItemName = new Scanner(System.in).nextLine();
                    Item[] foundItems = tracker.findByName(foundItemName);
                    if (foundItems.length > 0) {
                        for (byte i = 0; i < foundItems.length; i++) {
                            System.out.println(foundItems[i]);
                        }
                    } else {
                        System.out.println("Apparently, there are no elements with the name.");
                    }
                    break;
                case 6:
                    run = false;
                    break;
            }

        }
    }

    private void showMenu() {
        String[] menuItems = {
            "MENU.",
            "0. Add",
            "1. Show all items",
            "2. Edit item",
            "3. Delete item",
            "4. Find item by ID",
            "5. Find items by name",
            "6. Exit program",
            "Select:"
        };
        System.out.println(System.lineSeparator());
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(menuItems[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
