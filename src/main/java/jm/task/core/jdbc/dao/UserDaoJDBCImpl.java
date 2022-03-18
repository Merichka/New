package jm.task.core.jdbc.dao;

import antlr.Utils;
import jm.task.core.jdbc.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static String INSERT_USER = "INSERT INTO users(name, lastName, age) VALUES (?, ?, ?);";
    private static String UPDATE_USER = "UPDATE users SET age = ? WHERE id = ?";
    private static String DELETE_USER = "DELETE FROM users WHERE id = ?";

    public static List<User> createUsersTable(String query) {
        List<User> users = new ArrayList<>();

        try (Connection connection = Utils.getConnection();
             PreparedStatement preparedStatement = connection.PrepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                long Id = rs.getLong("id");
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                byte age = rs.getByte("age");

                long id = 0;
                users.add(new User(id, name, lastName, age));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static List<User> saveUser(User user) {
        List<User> users = new ArrayList<>();

        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.PrepareStatement(INSERT_USER)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setByte(3, user.getAge());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static List<User> updateUser(long userID, byte age) {
        List<User> updateUsers = new ArrayList<>();

        try (Connection connection = Utils.getConnection();
             PreparedStatement preparedStatement = connection.PrepareStatement(IUPDATE_USER)) {

            preparedStatement.setByte(1, age);
            preparedStatement.setLong(2, userID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void deleteUsers(long userId) {

        try (Connection connection = Utils.getConnection();
             PreparedStatement preparedStatement = connection.PrepareStatement(DELETE_USER)) {

            preparedStatement.setLong(1, userId);
            preparedStatement.executeUpdate();

            PreparedStatement allUsers.execute.Query();

        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println(getUserData("SELECT * FROM users"));


        }
    }



    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
