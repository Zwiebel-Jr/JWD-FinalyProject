package by.epam.service;

import by.epam.bean.User;

public interface UserService {
    User authorization(String login, String passport) throws ServiceException;
    boolean registration(User user) throws ServiceException;
}
