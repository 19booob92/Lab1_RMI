package com.pwr.lab8.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pwr.lab8.connection.CreateConnectionToDB;


public class CreateQueries {

    public static final String CREATE_TABLE_CAR = "CREATE TABLE IF NOT EXISTS car (id INTEGER primary key autoincrement, name varchar(30), date varchar(30), number varchar(10), cost INTEGER);";

    public static final String CREATE_TABLE_STATS = "CREATE TABLE IF NOT EXISTS stats (id INTEGER primary key autoincrement, name varchar(30), cost INTEGER);";

    private Connection connection;

    public CreateQueries(CreateConnectionToDB connector) {
        try {
            this.connection = connector.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCarTable() throws SQLException {
        Statement statement = connection.createStatement();

        try {
            statement.execute(CREATE_TABLE_CAR);
        } finally {
            try {
                statement.close();
            } catch (Exception ignore) {
            }
        }

    }

    public void createStatsTable() throws SQLException {
        Statement statement = connection.createStatement();

        try {
            statement.execute(CREATE_TABLE_STATS);
        } finally {
            try {
                statement.close();
            } catch (Exception ignore) {
            }
        }

    }

}
