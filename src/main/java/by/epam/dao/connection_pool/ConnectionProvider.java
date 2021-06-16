package by.epam.dao.connection_pool;

public class ConnectionProvider {
    private static final ConnectionProvider instance = new ConnectionProvider();

    private final ConnectionPool connectionPool = new ConnectionPool();

    private ConnectionProvider() {}

    public static ConnectionProvider getInstance() {return instance; }

    public ConnectionPool getConnectionPool(){
        return connectionPool;
    }

    public void initConnectionPool(){
        try{
            connectionPool.initPoolData();
        } catch (ConnectionPoolException e) {
            //logger.log(Level.ERROR, "ConnectionPool isn't init.");
        }
    }

    public void disposeConnectionPool(){
        connectionPool.dispose();
    }
}
