package model;

public class Book {
    private Integer id;
    private String title;
    private String print_year;
    private String author_name;

    public Book(Integer id, String title, String print_year, String author_name) {
        this.id = id;
        this.title = title;
        this.print_year = print_year;
        this.author_name = author_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrint_year() {
        return print_year;
    }

    public void setPrint_year(String print_year) {
        this.print_year = print_year;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", print_year='" + print_year + '\'' +
                ", author_name='" + author_name + '\'' +
                '}';
    }
}
