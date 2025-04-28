package com.example.book_library.Services;
import java.util.Collection;
import org.springframework.stereotype.Service;
import com.example.book_library.DTO.AuthorForm;
import com.example.book_library.Model.Author;
import com.example.book_library.Storage.AuthorStorage;
import com.example.book_library.Storage.BookStorage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorStorage authorStorage;  
    private final BookStorage bookStorage;

    public Collection<Author> getAuthors() {
        return authorStorage.getAll();
    }

    public Integer getAuthorsCount() {
        return authorStorage.getAll().size();
    }

    public Collection<Author> getByRegex(String regex) throws IllegalArgumentException {
        Collection<Author> authors = authorStorage.getByRegex(regex);
        if (authors == null) {
            throw new IllegalArgumentException("Автор не найден");
        }
        return authors;
    }

    public Author getByName(String firstName, String secondName) throws IllegalArgumentException {
        Author author = authorStorage.getByName(firstName, secondName);
        if (author == null) {
            throw new IllegalArgumentException("Автор не найден");
        }
        return author;
    }

    public void addAuthor(AuthorForm authorForm) {
        Author author = new Author(authorForm.getFirstName(), authorForm.getSecondName(), authorForm.getBirthday());
        authorStorage.addAuthor(author);
    }

    public Author getAuthor(Integer id) {
        Author author = authorStorage.getById(id);
        if (author == null) {
            throw new IllegalArgumentException("Автор не найден");
        }
        return author;
    }

    public void removeAuthor(Integer id) throws IllegalArgumentException {
        Author author = authorStorage.getById(id);
        bookStorage.removeByAuthor(author);
        authorStorage.removeAuthor(id);
    }
}
