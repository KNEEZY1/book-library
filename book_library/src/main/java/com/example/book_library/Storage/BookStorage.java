package com.example.book_library.Storage;
import java.util.Collection;
import com.example.book_library.Model.Author;
import com.example.book_library.Model.Book;

public interface BookStorage {
    
    public Book addBook(Book book);
    public void removeBook(int id);
    public void removeByAuthor(Author author);
    public Book getById(int id);
    public Book getByTitle(String title);
    public Collection<Book> getByAuthor(String firstName, String secondName);
    public Collection<Book> getAll();
}
