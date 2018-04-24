package application;

import connection.Connection;

import java.time.LocalDate;

public class Application {

    private static Connection httpConnection;
    private static Connection mqttConnection;
    private static Connection amqpConnection;

    //Create connection and log it status
    public static void main(String[] args) {
        initializeAllConnections();
        mockAllConnectionsStates();
        tryConnectLogAndDisconnectConnection(httpConnection);
    }

    private static void initializeAllConnections(){

        //Initialize httpConnection
        httpConnection = new Connection.Builder(20, "127.0.0.1", "HTTP")
                .setData("Hello World!")
                .build();

        //Initialize mqttConnection
        mqttConnection = new Connection.Builder(8080, "192.168.0.1", "MQTT")
                .setData(LocalDate.now().toString())
                .setShowWarnings(true)
                .setUseSSL(false)
                .setRetryWhenFail(true)
                .build();

        //Initialize amqpConnection
        amqpConnection = new Connection.Builder(7172, "172.8.15.34", "AMQP")
                .setData("{" +
                        "\"id\": 82," +
                        "\"name\": Szymon," +
                        "\"surname\": Marcinkiewicz" +
                        "}")
                .setGetRespondMessage(true)
                .build();
    }

    private static void mockAllConnectionsStates(){
        httpConnection.initializeConnection();
        mqttConnection.initializeConnection();
        amqpConnection.initializeConnection();
    }

    private static void logAllConnections(){
        System.out.format("%s%n", httpConnection.toString());
        httpConnection.getConnectionState().logConnectionState();

        System.out.format("%n%s%n", mqttConnection.toString());
        mqttConnection.getConnectionState().logConnectionState();

        System.out.format("%n%s%n", amqpConnection.toString());
        amqpConnection.getConnectionState().logConnectionState();
    }

    private static void tryConnectAllConnections(){
        httpConnection.connect();
        mqttConnection.connect();
        amqpConnection.connect();
    }

    private static void tryDisconnectAllConnections(){
        httpConnection.disconnect();
        mqttConnection.disconnect();
        amqpConnection.disconnect();
    }

    private static void tryConnectLogAndDisconnectConnection(Connection connection){
        connection.logConnectionState();
        System.out.format("%n%s%n", connection.toString());
        connection.connect();
        connection.disconnect();
    }

}
