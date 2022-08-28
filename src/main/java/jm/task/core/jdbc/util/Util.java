package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {
    public static Connection connectMethod() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dedusers", "root", "1Dothisf");
        return conn;
    }
}