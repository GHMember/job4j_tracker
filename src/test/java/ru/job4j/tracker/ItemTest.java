package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {

    @Test
    public void whenSortedItemsByNameAsc() {
        List<Item> items = Arrays.asList(
                new Item("Item2"),
                new Item("Item1"),
                new Item("Item3")
        );
        items.sort(new ItemAscByName());
        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String date = items.get(0).getCreated().format(FORMATTER);
        assertThat(items.toString()).isEqualTo("[Item{id=0, name='Item1', created="
                                                        + date + "}, Item{id=0, name='Item2', created="
                                                        + date + "}, Item{id=0, name='Item3', created="
                                                        + date + "}]");
    }

    @Test
    public void whenSortedItemsByNameDesc() {
        List<Item> items = Arrays.asList(
                new Item("Item2"),
                new Item("Item1"),
                new Item("Item3")
        );
        items.sort(new ItemDescByName());
        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String date = items.get(0).getCreated().format(FORMATTER);
        assertThat(items.toString()).isEqualTo("[Item{id=0, name='Item3', created="
                + date + "}, Item{id=0, name='Item2', created="
                + date + "}, Item{id=0, name='Item1', created="
                + date + "}]");
    }
}