package model;

public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String[] bookList;

    public Author(int id, String firstName, String lastName, int age, String[] bookList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bookList = bookList;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getBookList() {
        return bookList;
    }

    public void setBookList(String[] bookList) {
        this.bookList = bookList;
    }
}
