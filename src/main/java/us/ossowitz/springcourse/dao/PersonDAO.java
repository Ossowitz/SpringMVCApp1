package us.ossowitz.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import us.ossowitz.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM spring_db.person", new PersonMapper());
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM spring_db.person WHERE id = ?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        String SQL = """
                INSERT INTO spring_db.person
                VALUES (1, ?, ?, ?)
                """;
        try {
            var preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person updatedPerson) {
        String SQL = """
                UPDATE spring_db.person
                SET name = ?, age = ?, email = ?
                WHERE id = ?
                """;
        try {
            var preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setInt(2, updatedPerson.getAge());
            preparedStatement.setString(3, updatedPerson.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String SQL = """
                DELETE
                FROM spring_db.person
                WHERE id = ?
                """;
        try {
            var preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
