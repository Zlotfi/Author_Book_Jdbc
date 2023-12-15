package repository;

import connection.JdbcConnection;
import model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

        // تبدیل آرایه bookList به یک رشته جداگانه با استفاده از ویرگول (,)
        String bookListString = String.join(",", author.getBookList());

        preparedStatement.setString(4, bookListString);

        // اجرای استعلام و ذخیره سازی در دیتابیس
        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected;
    }
}
