package service;

import model.Book;
import repository.BookRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class BookService {

    Scanner scanner = new Scanner(System.in);

    private final BookRepository bookRepository = new BookRepository();

    public BookService() throws SQLException {
    }

    public void addBook(Book book) throws SQLException {
        int result = bookRepository.save(book);
        if (result != 0)
            System.out.println(book.getTitle() + " successfully added to database");
        else
            System.out.println("ERROR 404");
    }

    public Book load() throws SQLException {
        System.out.println("book_id: ");
        int book_id = scanner.nextInt();
        Book book = bookRepository.load(book_id);
        return book;
    }

    public void delete() throws SQLException {
        System.out.println("id: ");
        int id = scanner.nextInt();
        int result = bookRepository.delete(id);
        if (result != 0)
            System.out.println("successfully deleted from database");
        else
            System.out.println("Oops :(");
    }
}
