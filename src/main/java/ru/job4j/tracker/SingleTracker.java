package ru.job4j.tracker;

import ru.job4j.tracker.store.SqlTracker;

import java.sql.SQLException;
import java.util.List;

public final class SingleTracker {
    private Store memTracker = new SqlTracker() {
    };
    private static SingleTracker instance = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) throws SQLException {
        return memTracker.add(item);
    }

    public Item findById(int id) throws SQLException {
        return memTracker.findById(id);
    }

    public List<Item> findByName(String name) throws SQLException {
        return memTracker.findByName(name);
    }

    public List<Item> findAll() throws SQLException {
        return memTracker.findAll();
    }

    public boolean replace(int id, Item item) throws SQLException {
        return memTracker.replace(id, item);
    }

    public boolean delete(int id) throws SQLException {
        return memTracker.delete(id);
    }

}