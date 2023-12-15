package repository;

import connection.JdbcConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
