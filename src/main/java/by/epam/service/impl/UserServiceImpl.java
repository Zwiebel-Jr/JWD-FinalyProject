package by.epam.service.impl;

import by.epam.bean.User;
import by.epam.dao.DAOException;
import by.epam.dao.DAOProvider;
import by.epam.dao.UserDAO;
import by.epam.service.ServiceException;
import by.epam.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User authorization(String login, String passport) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDAO = provider.getUserDAO();
        User userAuth = null;
        try{
            userAuth = userDAO.authorization(login,passport);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return userAuth;
    }

    @Override
    public boolean registration(User user) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDAO = provider.getUserDAO();
        boolean result = false;
        try{
            result = userDAO.registration(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
