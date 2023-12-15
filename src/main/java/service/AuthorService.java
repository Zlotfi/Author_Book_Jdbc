package service;

import model.Author;
import repository.AuthorRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class AuthorService {

    Scanner scanner = new Scanner(System.in);

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

    public void load() throws SQLException {
        System.out.println("Author_id: ");
        int author_id = scanner.nextInt();
        Author author = authorRepository.load(author_id);
        System.out.println(author);
    }
}
