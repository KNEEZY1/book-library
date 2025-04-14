package com.example.book_library.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorForm {
    private String firstName;
    private String secondName;
    private int birthday;
}
