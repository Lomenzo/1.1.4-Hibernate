package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Petr", "Petrov", (byte)45);
        //userService.saveUser("Liza", "Smirnova", (byte)33);
        //userService.saveUser("Loh", "Lohov", (byte)15);
        //userService.saveUser("Alex", "Tankov", (byte)22);
        userService.getAllUsers();
        //userService.removeUserById(1);
        //userService.cleanUsersTable();
        //userService.dropUsersTable();



        /*UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Petr", "Petrov", (byte)45);
        userDaoJDBC.saveUser("Liza", "Smirnova", (byte)33);
        userDaoJDBC.saveUser("Loh", "Lohov", (byte)15);
        userDaoJDBC.saveUser("Alex", "Tankov", (byte)22);
        userDaoJDBC.getAllUsers();
            userDaoJDBC.removeUserById(1);
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();*/
    }
}

/*В методе main класса Main должны происходить следующие операции:

    -Создание таблицы User(ов)
    -Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть
    вывод в консоль ( User с именем – name добавлен в базу данных )
    -Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
    -Очистка таблицы User(ов)
    -Удаление таблицы*/