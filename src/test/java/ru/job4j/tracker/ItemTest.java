package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {

    @Test
    public void whenSortedItemsByNameAsc() {
        List<Item> items1 = Arrays.asList(
                new Item("Item2"),
                new Item("Item1"),
                new Item("Item3")
        );
        List<Item> items2 = Arrays.asList(
                new Item("Item2"),
                new Item("Item1"),
                new Item("Item3")
        );
        items1.sort(new ItemAscByName());
        items2.sort(new ItemAscByName());
        assertThat(items1.toString()).isEqualTo(items2.toString());
    }

    @Test
    public void whenSortedItemsByNameDesc() {
        List<Item> items1 = Arrays.asList(
                new Item("Item2"),
                new Item("Item1"),
                new Item("Item3")
        );
        List<Item> items2 = Arrays.asList(
                new Item("Item2"),
                new Item("Item1"),
                new Item("Item3")
        );
        items1.sort(new ItemDescByName());
        items2.sort(new ItemDescByName());
        assertThat(items1.toString()).isEqualTo(items2.toString());
    }
}