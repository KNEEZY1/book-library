package com.example.book_library.Model;

public enum Genre {
        FICTION("Художественная литература"),
        NON_FICTION("Нон-фикшн"),
        FANTASY("Фантастика"),
        SCIENCE("Научная литература"),
        HISTORY("История"),
        ROMANCE("Романтика");
    
        private final String title;
    
        Genre(String title) {
            this.title = title;
        }
    
        public String getTitle() {
            return title;
        }
    }
