package ru.job4j.tracker;

public class StartUI {

    public void init(Input consoleInput, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int selection = consoleInput.requestIntInput("Select:");
            switch (selection) {
                case 0:
                    Add(tracker);
                    break;
                case 1:
                    showAllItems(tracker);
                    break;
                case 2:
                    editItem(tracker);
                    break;
                case 3:
                    deleteItem(tracker);
                    break;
                case 4:
                    findItemById(tracker);
                    break;
                case 5:
                    findItemsByName(tracker);
                    break;
                case 6:
                    run = false;
                    break;
            }

        }
    }

    private void findItemsByName(Tracker tracker) {
        Input consoleInput = new ConsoleInput();
        String name = consoleInput.requestStringInput("Enter the item's name:");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (byte i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        } else {
            System.out.println("Apparently, there are no elements with the name.");
        }
    }

    private void findItemById(Tracker tracker) {
        Input consoleInput = new ConsoleInput();
        int id = consoleInput.requestIntInput("Enter the item's ID:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Apparently, there is no element with the ID.");
        }
    }

    private void deleteItem(Tracker tracker) {
        Input consoleInput = new ConsoleInput();
        int id = consoleInput.requestIntInput("Enter the deleted item's ID:");
        if (tracker.delete(id)) {
            System.out.printf("The element with ID %d has been deleted.\n", id);
        } else {
            System.out.println("Apparently, there is no element with the ID.");
        }
    }

    private void editItem(Tracker tracker) {
        Input consoleInput = new ConsoleInput();
        int id = consoleInput.requestIntInput("Enter the edited item's ID:");
        String name = consoleInput.requestStringInput("Enter new item's name:");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.printf("The element with ID %d has been updated.\n", id);
        } else {
            System.out.println("Apparently, there is no element with the ID.");
        }
    }

    private void showAllItems(Tracker tracker) {
        System.out.println("=== All available items ====");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("There are not available records.\n");
        }
    }

    private void Add(Tracker tracker) {
        System.out.println("=== Creating a new item ====");
        Input consoleInput = new ConsoleInput();
        String name = consoleInput.requestStringInput("Enter a name:");
        Item item = new Item(name);
        item = tracker.add(item);
        System.out.println("Item has been added successfully.");
        System.out.println(item);
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
            "6. Exit program"
        };
        System.out.println(System.lineSeparator());
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(menuItems[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
