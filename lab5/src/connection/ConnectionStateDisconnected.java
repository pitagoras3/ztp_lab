package connection;

public class ConnectionStateDisconnected implements ConnectionState{
    @Override
    public void logConnectionState() {
        System.out.println("Disconnected.");
    }
}
