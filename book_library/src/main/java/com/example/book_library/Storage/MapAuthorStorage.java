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
    public Collection<Author> getAll() {
        List<Author> sortedAuthors = new ArrayList<>(authors.values());
        sortedAuthors.sort(null);
        return sortedAuthors;
    }

    @Override
    public Author getById(Integer id) {
        return authors.get(id);
    }
        
    @Override
    public Collection<Author> getByRegex(String regex) {
        Pattern pattern = Pattern.compile(regex.toLowerCase());
        Matcher matcher;
        List<Author> resultList = new LinkedList<>();
        for (Author author : authors.values()) {
            String name = author.getFirstName() + " " + author.getSecondName();
            matcher = pattern.matcher(name.toLowerCase());
            if(matcher.find()) {
                resultList.add(author);
            }
        }
        return resultList;
    }

    @Override
    public Author getByName(String firstName, String secondName) {
        for(Author author : authors.values()) {
            if(author.getFirstName().equals(firstName) && author.getSecondName().equals(secondName)) {
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
}
