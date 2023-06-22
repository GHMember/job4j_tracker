package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.store.SqlTracker;

import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.assertj.core.api.Assertions.assertThat;

public class TrackerTest {

    @Test
    public void checkConnection() throws SQLException {
        SqlTracker tracker;
        try (SqlTracker trackerSQL = new SqlTracker()) {
            tracker = trackerSQL;
            assertThat(trackerSQL.isAvailable(), is(true));
        }
        assertThat(tracker.isAvailable(), is(false));
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws SQLException {
        try (SqlTracker memTracker = new SqlTracker()) {
            Item item = new Item();
            item.setName("test1");
            memTracker.add(item);
            Item result = memTracker.findById(item.getId());
            assertThat(result.getName(), is(item.getName()));
        }
    }

    @Test
    public void whenTestFindById() throws SQLException {
        try (SqlTracker memTracker = new SqlTracker()) {
            Item bug = new Item("Bug");
            Item item = memTracker.add(bug);
            Item result = memTracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenTestFindAll() throws SQLException {
        try (SqlTracker memTracker = new SqlTracker()) {
            ((SqlTracker) memTracker).deleteAll();
            Item first = new Item("First");
            Item second = new Item("Second");
            memTracker.add(first);
            memTracker.add(second);
            Item result = memTracker.findAll().get(0);
            assertThat(result.getName()).isEqualTo(first.getName());
        }
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() throws SQLException {
        try (SqlTracker memTracker = new SqlTracker()) {
            ((SqlTracker) memTracker).deleteAll();
            Item first = new Item("First");
            Item second = new Item("Second");
            memTracker.add(first);
            memTracker.add(second);
            memTracker.add(new Item("First"));
            memTracker.add(new Item("Second"));
            memTracker.add(new Item("First"));
            List<Item> result = memTracker.findByName(first.getName());
            assertThat(result.size()).isEqualTo(3);
        }
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() throws SQLException {
        try (SqlTracker memTracker = new SqlTracker()) {
            Item first = new Item("First");
            Item second = new Item("Second");
            memTracker.add(first);
            memTracker.add(second);
            memTracker.add(new Item("First"));
            memTracker.add(new Item("Second"));
            memTracker.add(new Item("First"));
            List<Item> result = memTracker.findByName(second.getName());
            assertThat(result.get(1).getName()).isEqualTo(second.getName());
        }
    }

    @Test
    public void whenReplace() throws SQLException {
        try (SqlTracker memTracker = new SqlTracker()) {
            Item bug = new Item();
            bug.setName("Bug");
            memTracker.add(bug);
            int id = bug.getId();
            Item bugWithDesc = new Item();
            bugWithDesc.setName("Bug with description");
            memTracker.replace(id, bugWithDesc);
            assertThat(memTracker.findById(id).getName()).isEqualTo("Bug with description");
        }
    }

    @Test
    public void whenDelete() throws SQLException {
        try (SqlTracker memTracker = new SqlTracker()) {
            Item bug = new Item();
            bug.setName("Bug");
            memTracker.add(bug);
            int id = bug.getId();
            memTracker.delete(id);
            assertThat(memTracker.findById(id)).isNull();
        }
    }
}