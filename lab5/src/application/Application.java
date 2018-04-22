package application;

import connection.Connection;

import java.time.LocalDate;

public class Application {

    private static Connection httpConnection;
    private static Connection mqttConnection;
    private static Connection amqpConnection;

    //Create connection and log it status
    public static void main(String[] args) {





    }

    private static void initializeConnections(){

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
}
