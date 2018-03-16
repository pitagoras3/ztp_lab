package com.marcinkiewicz.dao;

import java.sql.*;

public abstract class DAO_DB {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/university?useSSL=false";
    private static final String DB_LOGIN = "root";
    private static final String DB_PASSWORD = "root";

    private Connection connection;
    private Statement statement;

    void executeUpdate(String query){
        openConnection();

        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }

    void openConnection(){
        try{
            connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
            statement = connection.createStatement();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ResultSet executeQuery(String query){
        ResultSet resultSet = null;
        try{
            resultSet = statement.executeQuery(query);
        }
        catch (SQLException e){

        }
        return resultSet;
    }


}
