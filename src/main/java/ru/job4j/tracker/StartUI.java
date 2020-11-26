package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.IOutput;

public class StartUI {
    private final IOutput out;

    public StartUI(IOutput out) {
        this.out = out;
    }

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
        out.println("MENU.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        IOutput output = new ConsoleOutput();
        IInput input = new ConsoleInput(output);
        Tracker tracker = new Tracker();
        IUserAction[] actions = {
            new CreateAction(output),
            new ShowAllItemsAction(),
            new EditAction(),
            new FindItemByIdAction(),
            new FindItemsByNameAction(),
            new DeleteAction(),
            new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
