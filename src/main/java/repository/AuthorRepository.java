package repository;

import connection.JdbcConnection;
import model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class AuthorRepository {

    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public AuthorRepository() throws SQLException {
    }

    public int save(Author author) throws SQLException {
        String add = "INSERT INTO author (firstName, lastName, age, bookList) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1, author.getFirstName());
        preparedStatement.setString(2, author.getLastName());
        preparedStatement.setInt(3, author.getAge());

        String bookListString = String.join(",", author.getBookList());

        preparedStatement.setString(4, bookListString);

        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected;
    }

    public Author load(int id) throws SQLException {
        String query = "SELECT * FROM author WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int authorId = resultSet.getInt("id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            int age = resultSet.getInt("age");
            String bookListString = resultSet.getString("bookList");

            String[] bookList = bookListString.split(",");

            Author author = new Author(authorId, firstName, lastName, age, bookList);
            return author;
        } else {
            return null;
        }
    }
}
