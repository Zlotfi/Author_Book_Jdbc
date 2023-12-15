package service;

import model.Author;
import repository.AuthorRepository;

import java.sql.SQLException;

public class AuthorService {

    private final AuthorRepository authorRepository = new AuthorRepository();

    public AuthorService() throws SQLException {
    }

    public void register(Author author) throws SQLException {
        int result = authorRepository.save(author);
        if (result != 0)
            System.out.println(author.getFirstName() + " " + author.getLastName() + " successfully added to database");
        else
            System.out.println("ERROR 404");
    }
}
