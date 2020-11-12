package ru.job4j.pojo;

public class Book {
    private String name;
    private short pageNumber;

    public Book() {}

    public Book(String name, short pageNumber) {
        this.name = name;
        this.pageNumber = pageNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(short pageNumber) {
        this.pageNumber = pageNumber;
    }
}
