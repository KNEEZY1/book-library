package com.example.book_library.Model;


public class Book {
    
    private int id;
    
    private String title;
    private int year;
    private int pages;
    private Author author;

    public Book() {

    }

    public Book(String title, int year, int pages, Author author) {
        this.title = title;
        this.year = year;
        this.pages = pages;
        this.author = author;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [id = " + id + ", title = " + title + ", year = " + year + ", pages = " + pages + " ]";
    }
}
