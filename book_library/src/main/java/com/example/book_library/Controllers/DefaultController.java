package com.example.book_library.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.book_library.DTO.AuthorForm;
import com.example.book_library.DTO.BookForm;
import com.example.book_library.Services.AuthorService;
import com.example.book_library.Services.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DefaultController {


    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bookForm", new BookForm());
        model.addAttribute("authorForm", new AuthorForm());
        model.addAttribute("booksCount", bookService.getBooksCount());
        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("authorsCount", authorService.getAuthorsCount());
        model.addAttribute("authors", authorService.getAuthors());
        return "index";
    }
}