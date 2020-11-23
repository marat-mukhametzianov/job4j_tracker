package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

public class StartUI {

    public void init(IInput consoleInput, Tracker tracker, IUserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int selected = consoleInput.requestIntInput("Select:");
            IUserAction action = actions[selected];
            run = action.execute(consoleInput, tracker);
        }
    }

    private void showMenu(IUserAction[] actions) {
        System.out.println("MENU.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        IInput input = new ConsoleInput();
        Tracker tracker = new Tracker();
        IUserAction[] actions = {
            new CreateAction(),
            new ShowAllItemsAction(),
            new EditAction(),
            new FindItemByIdAction(),
            new FindItemsByNameAction(),
            new DeleteAction(),
            new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
