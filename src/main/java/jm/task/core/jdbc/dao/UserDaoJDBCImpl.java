package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    Util util = new Util();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Connection conn = util.connectMethod();
            Statement statement = conn.createStatement();
            int result = statement.executeUpdate("create table IF NOT EXISTS users1 \n ( \n ID bigint not null auto_increment, \n fName varchar(30), \n lastName varchar(30), \n Age tinyint, \n primary key (ID) \n )");
            System.out.println("UserTable create");
        } catch (SQLException e) {
            System.out.println("UserTable not create" + e);
        }
    }

    public void dropUsersTable() {
        try {
            Connection conn = util.connectMethod();
            Statement statement = conn.createStatement();
            int result = statement.executeUpdate("drop table if exists users1");
            System.out.println("UserTable drop-deleted");
        } catch (SQLException e) {
            System.out.println("UserTable not drop-deleted" + e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Connection conn = util.connectMethod();
            Statement statement = conn.createStatement();
            int result = statement.executeUpdate("insert users1(fName, lastName, Age)\n" + "values ('" + name + "', '" + lastName + "', " + age  + ");");
            System.out.println("User с именем – " + name + "добавлен в базу данных ");
        } catch (SQLException e) {
            System.out.println("not added" + e);
        }
    }

    public void removeUserById(long id) {
        try {
            Connection conn = util.connectMethod();
            Statement statement = conn.createStatement();
            int result = statement.executeUpdate("delete from users1\n" + "where ID='" + id  + "';");
            System.out.println("User with ID = " + id + " was REMOVED");
        } catch (SQLException e) {
            System.out.println("not removed user" + e);
        }
    }

    public List<User> getAllUsers() {
        List<User> list = null;
        try {
            Connection conn = util.connectMethod();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users1");
            list = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("Id");
                User user = new User(resultSet.getString("fName"), resultSet.getString("lastName"), resultSet.getByte("Age"));
                list.add(user);
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            System.out.println("not get" + e);
        }
        return list;
    }

    public void cleanUsersTable() {
        try {
            Connection conn = util.connectMethod();
            Statement statement = conn.createStatement();
            int result = statement.executeUpdate("truncate table users1;");                   //create table if not exists users1;
            System.out.println("UserTable cleaned");
        } catch (SQLException e) {
            System.out.println("UserTable not cleaned" + e);
        }
    }
}
