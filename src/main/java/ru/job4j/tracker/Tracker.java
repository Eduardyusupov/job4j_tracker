package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>(items.size());
        for (Item item : items) {
            if (key.equals(item.getName())) {
                rsl.add(item);
            }
        }
        return List.copyOf(rsl);
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean isFound = index != -1;
        if (isFound) {
            items.set(index, item);
            item.setId(id);
        }
        return isFound;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }
}