package com.memory.todobook;

import java.io.Serializable;

public class Book implements Serializable {

    public Book(int id, String title, String author, int pages){

        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;

    }


    private int id;
    private String title;
    private String author;
    private int pages;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }
}
