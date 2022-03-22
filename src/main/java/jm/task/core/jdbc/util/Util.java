package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String dbURL = "jdbc:postgresql:mem:test;INIT=RUNSCRIPT FROM 'classpath.sql'";
    private static String dbUsername = "SA";
    private static String dbPassword = "";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                properties.setProperty("hibernate.connection.url", URL);
                properties.setProperty("hibernate.connection.username", USER);
                properties.setProperty("hibernate.connection.password", PASSWORD);
                properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

                Configuration configuration = new Configuration()
                        .addProperties(properties).addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder =
                        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение в создании sessionFactory");
            }
        }
        return sessionFactory;
    }
}
