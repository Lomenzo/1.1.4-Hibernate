package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Util {
    // реализуйте настройку соединения с БД
    public static void connectMethod(String command) throws SQLException {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dedusers", "root", "1Dothisf")) {



            Statement statement = conn.createStatement();
            if (command.startsWith("SELECT")) {
                ResultSet resultSet = statement.executeQuery(command);
                List<User> list = new ArrayList<>();
                while(resultSet.next()) {
                    long id = resultSet.getLong("Id");
                    User user = new User(resultSet.getString("fName"), resultSet.getString("lastName"), resultSet.getByte("Age"));
                    System.out.println(user.toString());
                }
            } else {
                int result = statement.executeUpdate(command);
            }
            System.out.println("Connection succes");
        } catch (Exception connectDataBaseException) {
            System.out.println("Connection fail" + connectDataBaseException);
        }

    }



}



