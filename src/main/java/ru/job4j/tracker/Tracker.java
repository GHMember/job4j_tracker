package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                rsl[count] = items[i];
                count++;
            }
        }
       return Arrays.copyOf(rsl, count);
    }

    public boolean replace(int id, Item item) {
        boolean replaceCompleted = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            replaceCompleted = true;
        }
        return replaceCompleted;
    }

    public boolean delete(int id) {
        boolean deleteCompleted = false;
        int index = indexOf(id);
        if (index != -1) {
            int copyFrom = index + 1;
            int length = size - index;
            System.arraycopy(items, copyFrom, items, index, length);
            items[size - 1] = null;
            size--;
            deleteCompleted = true;
        }
        return deleteCompleted;
    }
}