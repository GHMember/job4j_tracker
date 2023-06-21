package ru.job4j.tracker;

import java.sql.SQLException;

public class ReplaceAction implements UserAction {

    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (memTracker.replace(id, item)) {
            out.println("Replacement was a success.");
        } else {
            out.println("Replacement was a fail.");
        }

        return true;
    }
}