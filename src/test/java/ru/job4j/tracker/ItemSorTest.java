package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.collection.ItemAscByName;
import ru.job4j.collection.ItemDescByName;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemSorTest {

    @Test
    void testAscItem() {
        List<Item> items = Arrays.asList(
                new Item(1, "Ivan"),
                new Item(2, "Fedor"),
                new Item(3, "Kraven")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "Fedor"),
                new Item(1, "Ivan"),
                new Item(3, "Kraven")

        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void testDescItem() {
        List<Item> items = Arrays.asList(
                new Item(1, "Ivan"),
                new Item(2, "Fedor"),
                new Item(3, "Kraven")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(3, "Kraven"),
                new Item(1, "Ivan"),
                new Item(2, "Fedor")
        );
        assertThat(items).isEqualTo(expected);
    }
}
