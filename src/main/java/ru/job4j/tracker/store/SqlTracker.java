package ru.job4j.tracker.store;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        try (PreparedStatement ps = cn.prepareStatement("INSERT INTO items(name, created) VALUES(?, ?)",
                                                        Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.execute();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        try (PreparedStatement ps = cn.prepareStatement("UPDATE items SET name=? WHERE id=?")) {
            ps.setString(1, item.getName());
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try (PreparedStatement ps = cn.prepareStatement("DELETE FROM items WHERE id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM items")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(createItem(rs));
            }
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM items WHERE name=?")) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(createItem(rs));
            }
        }
        return result;
    }

    @Override
    public Item findById(int id) throws SQLException {
        Item item = null;
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM items WHERE id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               item = createItem(rs);
            }
        }
        return item;
    }

    private Item createItem(ResultSet rs) throws SQLException {
        Item item = new Item(rs.getInt("id"), rs.getString("name"));
        Timestamp created = rs.getTimestamp("created");
        item.setCreated(created.toLocalDateTime());
        return item;
    }

    public void deleteAll() throws SQLException {
        try (PreparedStatement ps = cn.prepareStatement("DELETE FROM items")) {
            ps.execute();
        }
    }
}
