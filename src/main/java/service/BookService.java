package service;

import model.Book;
import repository.BookRepository;

import java.sql.SQLException;

public class BookService {

    private final BookRepository bookRepository = new BookRepository();

    public BookService() throws SQLException {
    }

    public void addBook(Book book) throws SQLException {
        int result = bookRepository.save(book);
        if (result != 0)
            System.out.println(book.getTitle() + "successfully added to database");
        else
            System.out.println("ERROR 404");
    }
}
