package menu;

import model.Author;
import model.Book;
import service.AuthorService;
import service.BookService;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final AuthorService authorService = new AuthorService();
    private final BookService bookService = new BookService();

    public Menu() throws SQLException {
    }

    public void publicMenu() throws SQLException {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("***Welcome***");
            System.out.println("1- Author");
            System.out.println("2- Book");
            System.out.println("3- Exit");
            System.out.println("Enter your select: ");
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> {
                    System.out.println("====================================");
                    System.out.println("1- save Author");
                    System.out.println("2- load Author");
                    System.out.println("3- Exit");
                    System.out.println("enter your number: ");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    switch (number) {
                        case 1 -> registerAuthor();
                        case 2 -> authorService.load();
                        case 3 -> isTrue = false;
                        default -> System.out.println("ERROR");
                    }
                }
                case 2 -> {
                    System.out.println("=============================");
                    System.out.println("1- add Book");
                    System.out.println("2- load Book");
                    System.out.println("3- delete Book");
                    System.out.println("4- Exit");
                    System.out.println("enter your number: ");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    switch (number){
                        case 1 -> registerBook();
                        case 2 -> bookService.load();
                        case 3 -> bookService.delete();
                        case 4 -> isTrue = false;
                        default -> System.out.println("ERROR");
                    }
                }
                case 3 -> isTrue = false;
                default -> System.out.println("ERROR");
            }
        }
    }

    public void registerAuthor() throws SQLException {
        System.out.println("Enter your firstName: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter your lastName: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your bookList:");
        String[] bookList = new String[]{scanner.nextLine()};

        Author author = new Author(null,firstName,lastName,age,bookList);
        authorService.register(author);
    }

    public void registerBook() throws SQLException {
        System.out.println("Enter your title: ");
        String title = scanner.nextLine();

        System.out.println("Enter your print_year: ");
        String print_year = scanner.nextLine();

        System.out.println("Enter your author_name: ");
        String author_name = scanner.nextLine();

        Book book = new Book(null, title, print_year, author_name);
        bookService.addBook(book);
    }
}
