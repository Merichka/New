package jm.task.core.jdbc;

import antlr.Utils;
import com.mysql.cj.util.Util;
import jm.task.core.jdbc.model.User;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Utils.createUsersTable("SELECT * FROM users");
        System.out.println(users);

        User user = new User();
        user.setName("Bob");
        user.setLastName("Bobby");
        user.setAge((byte) 20);

        System.out.println(Utils.saveUser(user));

        System.out.println(Utils.updateUser(2, "Иванов"));

        System.out.println(Utils.deleteUsers(1));

    }
}