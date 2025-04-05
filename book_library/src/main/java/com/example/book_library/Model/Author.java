package com.example.book_library.Model;

public class Author {
    private int id;

    private String firstName;
    private String secondName;
    private int birthday;

    
    public Author() {
    }
    
    public Author(String firstName, String secondName, int birthday) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public int getBirthday() {
        return birthday;
    }
    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Author [id = " + id + ", firstName = " + firstName + ", secondName = " + secondName + ", birthday = " + birthday
                + " ]";
    }

    
}