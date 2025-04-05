package com.example.book_library.Storage;

import java.util.Collection;
import com.example.book_library.Model.Author;

public interface AuthorStorage {
    public Author addAuthor(Author author);
    public Author getById(Integer id);
    public Author getByName(String firstName, String secondName);
    public void removeAuthor(int id);
    public Collection<Author> getAll();   
}
