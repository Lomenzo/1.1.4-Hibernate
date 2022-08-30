package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.imageio.spi.ServiceRegistry;

import java.sql.*;
import java.util.Properties;


public class Util {
    public static Connection connectMethod() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dedusers", "root", "1Dothisf");
        return conn;
    }

    private static SessionFactory sessionFactory = getSessionFactory();

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();

                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost/dedusers");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "1Dothisf");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "validate");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);




            } catch (Exception e) {
                System.out.println("Исключение при создании sessionFactory");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static SessionFactory getSession() {
        return sessionFactory;
    }
}