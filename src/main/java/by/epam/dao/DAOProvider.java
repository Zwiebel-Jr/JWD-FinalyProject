package by.epam.dao;

import by.epam.dao.impl.UserDAOimpl;

public class DAOProvider {
    private static final DAOProvider instanse = new DAOProvider();

    private final UserDAO userdao = new UserDAOimpl();

    private DAOProvider() {
    }

    public static DAOProvider getInstance() {
        return instanse;
    }

    public UserDAO getUserDAO() {
        return userdao;
    }
}
