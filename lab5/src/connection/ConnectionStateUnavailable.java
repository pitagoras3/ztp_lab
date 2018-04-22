package connection;

public class ConnectionStateUnavailable implements ConnectionState {

    @Override
    public void logConnectionState() {
        System.out.println("Connection unavailable.");
    }
}
