package com.example.book_library.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.book_library.Model.Author;
import com.example.book_library.Storage.AuthorStorage;
import com.example.book_library.DTO.AuthorForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorStorage authorService;

    
    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute AuthorForm authorForm) {
        Author author = new Author(authorForm.getFirstName(), authorForm.getSecondName(), authorForm.getBirthday());
        authorService.addAuthor(author);
        return "redirect:/";
    }

    @GetMapping("/getAuthor{id}")
    public String getMethodName(@RequestParam("id") Integer id, Model model) {
        try {
            Author author = authorService.getById(id);
            model.addAttribute("author", author);
            return "author";
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return "redirect:/";
        }
    }

    @PostMapping("/removeAuthor")
    public String removeAuthor(@RequestParam("id") Integer id) {
        try {
            authorService.removeAuthor(id);
            return "redirect:/";
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return "redirect:/";
        }
    }
    
}