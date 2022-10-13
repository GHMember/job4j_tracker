package ru.job4j.tracker;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exiting the program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Exiting the program ===");

        return false;
    }
}
