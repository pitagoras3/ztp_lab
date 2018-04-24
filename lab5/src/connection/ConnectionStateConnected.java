package connection;

public class ConnectionStateConnected implements ConnectionState{

    @Override
    public void connect(Connection connection) {
        System.out.println("Can't connect, connection is working currently.");
    }

    @Override
    public void logConnectionState() {
        System.out.println("Connected.");
    }

    @Override
    public void disconnect(Connection connection) {
        System.out.println("Disconnecting...");
        connection.setConnectionState(new ConnectionStateDisconnected());
        System.out.println("Disconnected.");
    }
}
