package ru.job4j.tracker;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exiting the program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Exiting the program ===");

        return false;
    }
}
