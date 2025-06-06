package ru.job4j.pojo;

public class Book {
    private String name;
    private int pageNumbers;

    public Book(int pageNumbers, String name) {
        this.pageNumbers = pageNumbers;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(short pageNumbers) {
        this.pageNumbers = pageNumbers;
    }
}
