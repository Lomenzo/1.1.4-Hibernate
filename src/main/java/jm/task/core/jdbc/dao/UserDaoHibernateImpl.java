package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    Util util = new Util();
    Session session = null;


    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
            try {
                session = util.getSession().getCurrentSession();
                session.beginTransaction();
                User user = new User(name, lastName, age);
                System.out.println(user);
                session.save(user);
                //-----вывод юзера в консоль для проверки-----
                System.out.println(user.getId());
                System.out.println(user.getName());
                System.out.println(user.getLastName());
                System.out.println(user.getAge());
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

            System.out.println(user.toString());

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("not get" + e);
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {

    }
}
