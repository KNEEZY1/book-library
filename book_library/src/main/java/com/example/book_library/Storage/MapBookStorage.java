package com.example.book_library.Storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.example.book_library.Model.Author;
import com.example.book_library.Model.Book;

public class MapBookStorage implements BookStorage {

    private final Map<Integer, Book> books;
    private int lastId;
    
        

    public MapBookStorage() {
        books = new HashMap<>();
        lastId = 0;
    }

    @Override
    public Book addBook(Book book) {
        book.setId(lastId);
        books.put(lastId++, book);
        return book;
    }

    @Override
    public Collection<Book> getAll() {
        return books.values();
    }

    @Override
    public Collection<Book> getByAuthor(String firstName, String secondName) {
        List<Book> bookList = new LinkedList<>();
        for (Book book : books.values()) {
            Author author = book.getAuthor();
            if (author.getFirstName().equals(firstName) && author.getSecondName().equals(secondName)); {
                bookList.add(book);
            }
        }
        return bookList;
    }

    @Override
    public Book getById(int id) {
        return books.get(id);
    }

    @Override
    public Book getByTitle(String title) {
        for (Book book : books.values()) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void removeBook(int id) {
        books.remove(id);
    }
    
}
