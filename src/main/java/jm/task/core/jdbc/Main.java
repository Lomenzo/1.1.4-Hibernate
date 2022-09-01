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

        //UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        //userDaoHibernate.createUsersTable();
        //userDaoHibernate.saveUser("Petr", "Petrov", (byte)45);
        //userDaoHibernate.saveUser("Liza", "Smirnova", (byte)33);
        //userDaoHibernate.saveUser("Loh", "Lohov", (byte)15);
        //userDaoHibernate.saveUser("Alex", "Tankov", (byte)22);
        //userDaoHibernate.getAllUsers();
        //userDaoHibernate.removeUserById(1);
        //userDaoHibernate.cleanUsersTable();
        //userDaoHibernate.dropUsersTable();

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Petr", "Petrov", (byte)45);
        userService.saveUser("Liza", "Smirnova", (byte)33);
        userService.saveUser("Loh", "Lohov", (byte)15);
        userService.saveUser("Alex", "Tankov", (byte)22);
        userService.getAllUsers();
        userService.removeUserById(1);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

/*В методе main класса Main должны происходить следующие операции:

    -Создание таблицы User(ов)
    -Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть
    вывод в консоль ( User с именем – name добавлен в базу данных )
    -Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
    -Очистка таблицы User(ов)
    -Удаление таблицы*/