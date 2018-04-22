package connection;

public class ConnectionStateAvailable implements ConnectionState {

    @Override
    public void logConnectionState() {
        System.out.println("Connection available.");
    }
}
