package application;

import connection.Connection;

public class Application {

    //Create connection and log it status
    public static void main(String[] args) {

        Connection httpConnection = new Connection.Builder(8080, "127.0.0.1", "HTTP")
                .setData("Hello World!")
                .build();

    }
}
