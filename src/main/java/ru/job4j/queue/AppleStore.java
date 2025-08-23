package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer lastHappy = null;
        for (int i = 0; i < count; i++) {
            lastHappy = queue.poll();
        }
        return lastHappy.name();
    }

    public String getFirstUpsetCustomer() {
        int firstUnhappyIndex = count + 1;
        Customer firstUnhappy = null;
        for (int i = 0; i < firstUnhappyIndex; i++) {
            firstUnhappy = queue.poll();
        }
        return firstUnhappy.name();
    }
}