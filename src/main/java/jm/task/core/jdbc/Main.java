package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        //userDaoHibernate.saveUser("Liza", "Smirnova", (byte)33);
        userDaoHibernate.removeUserById(2);

        //UserServiceImpl userService = new UserServiceImpl();
        //userService.createUsersTable();

        /*Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost/dedusers");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "1Dothisf");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL55Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "create");

        configuration.setProperties(settings);
        configuration.addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = null;
        session = sessionFactory.getCurrentSession();*/







        /*UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Petr", "Petrov", (byte)45);
        userService.saveUser("Liza", "Smirnova", (byte)33);
        userService.saveUser("Loh", "Lohov", (byte)15);
        userService.saveUser("Alex", "Tankov", (byte)22);
        userService.getAllUsers();
        userService.removeUserById(1);
        userService.cleanUsersTable();
        userService.dropUsersTable();*/
    }
}

/*В методе main класса Main должны происходить следующие операции:

    -Создание таблицы User(ов)
    -Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть
    вывод в консоль ( User с именем – name добавлен в базу данных )
    -Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
    -Очистка таблицы User(ов)
    -Удаление таблицы*/