package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime currentTime = item.getTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentTimeFormat = currentTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentTimeFormat);
    }

}
