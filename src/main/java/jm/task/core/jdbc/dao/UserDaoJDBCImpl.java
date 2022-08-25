package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Util util = new Util();
        try {
            util.connectMethod("create table IF NOT EXISTS users1 \n ( \n ID bigint not null auto_increment, \n fName varchar(30), \n lastName varchar(30), \n Age tinyint, \n primary key (ID) \n )");

        } catch (SQLException e) {
            System.out.println("UserTable not create" + e);
        }
    }

    public void dropUsersTable() {
        Util util = new Util();
        try {
            util.connectMethod("drop table users1");
        } catch (SQLException e) {
            System.out.println("UserTable not drop-deleted" + e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Util util = new Util();
        try {
            util.connectMethod("insert users1(fName, lastName, Age)\n" + "values ('" + name + "', '" + lastName + "', " + age  + ");");
            System.out.println("User с именем – " + name + "добавлен в базу данных ");
        } catch (SQLException e) {
            System.out.println("not added" + e);
        }
    }

    public void removeUserById(long id) {
        Util util = new Util();
        try {
            util.connectMethod("delete from users1\n" + "where ID='" + id  + "';");
            System.out.println("User with ID = " + id + " was REMOVED");
        } catch (SQLException e) {
            System.out.println("not removed user" + e);
        }
    }

    public List<User> getAllUsers() {

        Util util = new Util();

        try {
            util.connectMethod("SELECT * FROM users1");

            System.out.println("get");
        } catch (SQLException e) {
            System.out.println("not get" + e);
        }


        return null;
    }


    public void cleanUsersTable() {
        Util util = new Util();
        try {
            util.connectMethod("create table if not exists users1; \n truncate table users1");
        } catch (SQLException e) {
            System.out.println("UserTable not cleaned" + e);
        }
    }
}
