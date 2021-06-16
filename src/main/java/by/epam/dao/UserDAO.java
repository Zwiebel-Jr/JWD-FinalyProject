package by.epam.dao;

import by.epam.bean.User;

public interface UserDAO {
    boolean registration(User user) throws DAOException;
    User authorization(String login, String password) throws DAOException;
}
