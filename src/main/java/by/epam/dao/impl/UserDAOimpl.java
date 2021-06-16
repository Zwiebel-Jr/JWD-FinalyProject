package by.epam.dao.impl;

import by.epam.bean.User;
import by.epam.dao.DAOException;
import by.epam.dao.UserDAO;
import by.epam.dao.connection_pool.ConnectionPool;
import by.epam.dao.connection_pool.ConnectionPoolException;
import by.epam.dao.connection_pool.ConnectionProvider;

import java.sql.*;

public class UserDAOimpl implements UserDAO {

    static {
        MySQLDriverLoader.getInstance();
    }

    @Override
    public boolean registration(User user) throws DAOException {
        boolean result = true;
        Connection connection = null;
        Statement statement = null;
        ConnectionProvider provider = ConnectionProvider.getInstance();
        ConnectionPool connectionPool = provider.getConnectionPool();

        try{
            connectionPool.initPoolData();
            connection = connectionPool.takeConnection();
            statement = connection.createStatement();

            String query = "INSERT INTO user(login,password,email, client_id_client) " +
                    "VALUES('"
                    + user.getName() + "','"
                    + user.getPassword() + "','"
                    + user.getEmail() + "','"
                    + user.getId() + "')";

            statement.executeUpdate(query);
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            result = false;
        } finally {
            try{
                connection.close();
            } catch (SQLException throwables) {
                throw new DAOException(throwables);
            }
        }
        return result;
    }

    @Override
    public User authorization(String login, String password) throws DAOException {
        boolean result = true;
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ConnectionProvider provider = ConnectionProvider.getInstance();
        ConnectionPool connectionPool = provider.getConnectionPool();

        try{
            connectionPool.initPoolData();
            connection = connectionPool.takeConnection();
            String query = "select * from user where login=? and password=?";
            statement = connection.prepareStatement(query);
           // PreparedStatement ps = this.con.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet rs  = statement.executeQuery();

            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
