package ru.job4j.tracker;

public final class SingleTracker {
    private Tracker tracker = new Tracker();
    private static SingleTracker instance = null;

    private SingleTracker() {

    }

    public static SingleTracker getTracker() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
         tracker.delete(id);
    }

}
