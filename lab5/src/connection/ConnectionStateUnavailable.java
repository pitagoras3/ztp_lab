package connection;

public class ConnectionStateUnavailable implements ConnectionState {

    @Override
    public String logConnectionState() {
        return null;
    }
}
