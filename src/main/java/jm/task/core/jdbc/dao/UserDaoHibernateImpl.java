package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    Util util = new Util();
    Session session = null;

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            session = util.getSession().getCurrentSession();
            session.beginTransaction();
            session.createSQLQuery("create table IF NOT EXISTS users1 \n ( \n " +
                                        "ID bigint not null auto_increment, \n " +
                                        "fName varchar(30), \n " +
                                        "lastName varchar(30), \n " +
                                        "Age tinyint, \n " +
                                        "primary key (ID) \n )")
                                        .executeUpdate();
            session.getTransaction().commit();
            System.out.println("UserTable create");
        } catch (Exception e) {
            System.out.println("UserTable not create" + e);
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            session = util.getSession().getCurrentSession();
            session.beginTransaction();
            session.createSQLQuery("drop table if exists users1").executeUpdate();
            session.getTransaction().commit();
            System.out.println("UserTable drop-deleted");
        } catch (Exception e) {
            System.out.println("UserTable not drop-deleted" + e);
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
            try {
                session = util.getSession().getCurrentSession();
                session.beginTransaction();
                User user = new User(name, lastName, age);
                System.out.println(user);
                session.save(user);
                session.getTransaction().commit();
                System.out.println("User с именем – " + name + "добавлен в базу данных ");
            } catch (Exception e) {
                System.out.println("not added" + e);
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
    }

    @Override
    public void removeUserById(long id) {
        try {
            session = util.getSession().getCurrentSession();
            session.beginTransaction();
            User user = session.load(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            System.out.println("User with ID = " + id + " was REMOVED");
        } catch (Exception e) {
            System.out.println("not removed user" + e);
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = null;
        try {
            session = util.getSession().getCurrentSession();
            session.beginTransaction();
            list = new ArrayList<>();
            list = session.createCriteria(User.class).list();
            list.forEach(System.out::println);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("not get" + e);
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        try {
            session = util.getSession().getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete from users1").executeUpdate();
            session.getTransaction().commit();
            System.out.println("UserTable cleaned");
        } catch (Exception e) {
            System.out.println("UserTable not cleaned" + e);
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
