package com.example.book_library.Storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

import com.example.book_library.Model.Author;
import com.example.book_library.Model.Book;
import com.example.book_library.Model.BookAuthorComparator;

@Repository
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
        List<Book> sortedBooks = new ArrayList<>(books.values());
        sortedBooks.sort(null);
        return sortedBooks;
    }

    public Collection<Book> getAllSorted() {
        List<Book> sortedBooks = new ArrayList<>(books.values());
        sortedBooks.sort(new BookAuthorComparator());
        return sortedBooks;
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
    public Collection<Book> getByTitle(String regexp) {
        Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        List<Book> resultList = new LinkedList<>();
        for (Book book : books.values()) {
            String title = book.getTitle().toLowerCase();
            matcher = pattern.matcher(title);
            if(matcher.find()) {
                resultList.add(book);
            }
        }
        return resultList;
    }

    @Override
    public void removeBook(int id) {
        books.remove(id);
    }
    
    // TODO: Не удаляет
    @Override
    public void removeByAuthor(Author author) {
        List<Integer> ids = new LinkedList<>();
        for(Book book : books.values()) {
            if(book.getAuthor().getId() == author.getId()) {
                ids.add(book.getId());
            }
        }
        for(Integer id : ids) {
            books.remove(id);
        }
    }
}
