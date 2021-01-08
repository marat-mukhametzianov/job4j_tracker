package ru.job4j.tracker.input;

import org.junit.Test;
import ru.job4j.tracker.output.IOutput;
import ru.job4j.tracker.output.StubOutput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidInputTest {

    @Test
    public void whenWrong() {
        String[] answers = {"one", "1"};
        IInput input = new StubInput(answers);
        IOutput output = new StubOutput();
        IInput validInput = new ValidInput(output, input);
        int selected = validInput.requestIntInput("Select:");
        assertThat(output.toString(),
                is("Try to input the valid number." + System.lineSeparator()));
    }

    @Test
    public void whenCorrect() {
        String[] answers = {"1"};
        IInput input = new StubInput(answers);
        IOutput output = new StubOutput();
        IInput validInput = new ValidInput(output, input);
        int selected = validInput.requestIntInput("Select:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenWrongThenCorrect() {
        String[] answers = {"one", "1"};
        IInput input = new StubInput(answers);
        IOutput output = new StubOutput();
        IInput validInput = new ValidInput(output, input);
        int selected = validInput.requestIntInput("Select:");
        assertThat(output.toString(),
                is("Try to input the valid number." + System.lineSeparator()));
        assertThat(selected, is(1));
    }
}