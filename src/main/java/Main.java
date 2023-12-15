import menu.Menu;
import model.Author;
import model.Book;
import repository.AuthorRepository;
import service.AuthorService;
import service.BookService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AuthorService authorService = new AuthorService();
        BookService bookService = new BookService();
        Author author = new Author(null,"zahra","lotfi",22, new String[]{"bidarii", "hasti", "siahat"});
        Author author1 = new Author(null,"farhad","hasan zade",52, new String[]{"ziba sedayam kon", "havij bastani"});

        Book book = new Book(null,"hasti","1380","zahra lotfi");
//        authorService.register(author1);
//        authorService.load(2);

//        bookService.addBook(book);
//        bookService.load();
//        bookService.delete(2);
        Menu menu = new Menu();
        menu.publicMenu();
    }
}
