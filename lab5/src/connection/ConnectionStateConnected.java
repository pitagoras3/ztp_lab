package connection;

public class ConnectionStateConnected implements ConnectionState{

    @Override
    public void logConnectionState() {
        System.out.println("Connected.");
    }
}
