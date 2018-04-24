package connection;

public interface ConnectionState {
    int AMOUNT_OF_CONNECTION_TYPES = 4;
    void connect(Connection connection);
    void logConnectionState();
    void disconnect(Connection connection);
}
