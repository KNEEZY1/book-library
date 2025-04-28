package com.example.book_library.DTO;
import com.example.book_library.Model.Genre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookForm {
    private String title;
    private int year;
    private int pages;
    private String author;
    private Genre genre; 
}
