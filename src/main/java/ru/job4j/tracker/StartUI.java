package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.input.ValidInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.IOutput;

import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final IOutput out;

    public StartUI(IOutput out) {
        this.out = out;
    }

    public void init(IInput consoleInput, Tracker tracker, List<IUserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int selected = consoleInput.requestIntInput("Select:");
            if (selected < 0 || selected >= actions.size()) {
                out.println("Wrong selected item. It can be 0 through " + (actions.size() - 1));
                continue;
            }
            IUserAction action = actions.get(selected);
            run = action.execute(consoleInput, tracker);
        }
    }

    private void showMenu(List<IUserAction> actions) {
        out.println("MENU.");
        int counter = 0;
        for (IUserAction action : actions) {
            out.println(counter++ + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        IOutput output = new ConsoleOutput();
        IInput input = new ValidInput(output, new ConsoleInput(output));
        Tracker tracker = new Tracker();
        List<IUserAction> actions = Arrays.asList(
            new CreateAction(output),
            new ShowAllItemsAction(output),
            new EditAction(output),
            new FindItemByIdAction(output),
            new FindItemsByNameAction(output),
            new DeleteAction(output),
            new ExitAction()
        );
        new StartUI(output).init(input, tracker, actions);
    }
}
