package ru.job4j.tracker;

import java.sql.SQLException;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (memTracker.delete(id)) {
            out.println("Item with id " + id + " has been deleted.");
        } else {
            out.println("It is not possible to delete the item with id " + id + ".");
        }
        return true;
    }
}