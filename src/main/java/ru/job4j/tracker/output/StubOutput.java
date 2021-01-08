package ru.job4j.tracker.output;

import ru.job4j.tracker.output.IOutput;

public class StubOutput implements IOutput {
    private final StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void println(Object object) {
        if (object != null) {
            stringBuilder.append(object.toString());
        } else {
            stringBuilder.append("null");
        }
        stringBuilder.append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
