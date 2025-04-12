package com.example.book_library.Storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.book_library.Model.Author;

@Repository
public class MapAuthorStorage implements AuthorStorage {

    private final Map<Integer, Author> authors;
    private int lastId;

    public MapAuthorStorage() {
        authors = new HashMap<>();
        lastId = 0;
    }

    @Override
    public Author addAuthor(Author author) {
        author.setId(lastId);   
        authors.put(lastId++, author);
        return author;
    }

    @Override
    public Author getById(Integer id) {
        return authors.get(id);
    }
        
    @Override
    public Author getByName(String firstName, String secondName) {
        for (Author author : authors.values()) {
            if (author.getFirstName().equals(firstName) && author.getSecondName().equals(secondName)) {
                return author;
            }
        }
        return null;
    }
    
    @Override
    public void removeAuthor(int id) {
        if(authors.containsKey(id)) {
        authors.remove(id);
        } else {
            throw new IllegalArgumentException("Автор не найден");
        }
    }

    @Override
        public Collection<Author> getAll() {
            return authors.values();
        }
}
