package connection;

public class ConnectionStateDisconnected implements ConnectionState{

    @Override
    public void connect(Connection connection) {
        System.out.println("Connecting...");
        connection.setConnectionState(new ConnectionStateConnected());
        System.out.println("Connected.");
    }

    @Override
    public void logConnectionState() {
        System.out.println("Disconnected.");
    }

    @Override
    public void disconnect(Connection connection) {
        System.out.println("Can't disconnect, connection is not working currently.");

    }
}
