package connection;

public class ConnectionStateUnavailable implements ConnectionState {

    @Override
    public void connect(Connection connection) {
        System.out.println("Connecting...");
        System.out.println("Can't connect to host.");
    }

    @Override
    public void logConnectionState() {
        System.out.println("Connection unavailable.");
    }

    @Override
    public void disconnect(Connection connection) {
        System.out.println("Can't disconnect, connection is not working currently.");
    }
}
