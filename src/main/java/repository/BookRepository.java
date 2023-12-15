package repository;

import connection.JdbcConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepository {

    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public BookRepository() throws SQLException {
    }

    public int save(Book book) throws SQLException {
        String add = "INSERT INTO book (title, print_year, author_name) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1,book.getTitle());
        preparedStatement.setString(2,book.getPrint_year());
        preparedStatement.setString(3,book.getAuthor_name());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public Book load(int id) throws SQLException {
        String query = "SELECT * FROM book WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            Book book = new Book(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("print_year"),
                    resultSet.getString("author_name")
            );
            System.out.println(book);
            return book;
        }
        else
            return null;
    }
}
