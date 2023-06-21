package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        out.println("=== Show all items ===");
        List<Item> items = memTracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Storage doesn't contain items.");
        }

        return true;
    }
}