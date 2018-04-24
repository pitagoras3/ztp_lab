package connection;

public class ConnectionStateAvailable implements ConnectionState {

    @Override
    public void connect(Connection connection) {
        System.out.println("Connecting...");
        connection.setConnectionState(new ConnectionStateConnected());
        System.out.println("Connected.");
    }

    @Override
    public void logConnectionState() {
        System.out.println("Connection available.");
    }

    @Override
    public void disconnect(Connection connection) {
        System.out.println("Disconnecting...");
        connection.setConnectionState(new ConnectionStateDisconnected());
        System.out.println("Disconnected.");
    }

}
