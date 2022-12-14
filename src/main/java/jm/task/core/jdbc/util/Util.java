package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.*;
import java.util.Properties;


public class Util {
    public static Connection connectMethod() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dedusers", "root", "1Dothisf");
        return conn;
    }

    private static SessionFactory sessionFactory = getSessionFactory();

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();

        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost/dedusers");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "1Dothisf");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL55Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");

        configuration.setProperties(settings);
        configuration.addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        return sessionFactory;
    }

    public static SessionFactory getSession() {
        return sessionFactory;
    }
}