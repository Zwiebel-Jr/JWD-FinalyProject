package by.epam.dao.impl;

import by.epam.dao.DBDriverLoadingException;

public class MySQLDriverLoader {

    private static final MySQLDriverLoader instance = new MySQLDriverLoader();
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            throw new DBDriverLoadingException(e);
        }
    }

    private MySQLDriverLoader() {
    }

    public static MySQLDriverLoader getInstance() {
        return instance;
    };

}
