package com.example.book_library.Services;
import java.util.Collection;
import org.springframework.stereotype.Service;
import com.example.book_library.DTO.AuthorForm;
import com.example.book_library.Model.Author;
import com.example.book_library.Storage.AuthorStorage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorStorage authorStorage;

    public Collection<Author> getAuthors() {
        return authorStorage.getAll();
    }

    public Integer getAuthorsCount() {
        return authorStorage.getAll().size();
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

    // TODO: Удалить все книги перед удалением автора (получ список всех книг, пройтись по нему, где авторы совпадают там удалить и после этого удаление автора)    
    public void removeAuthor(Integer id) throws IllegalArgumentException {
        authorStorage.removeAuthor(id);
    }
}
