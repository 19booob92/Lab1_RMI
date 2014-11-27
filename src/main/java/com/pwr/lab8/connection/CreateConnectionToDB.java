package com.pwr.lab8.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateConnectionToDB {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);

        String dbName = "myjniaDB.db";
        String driverName = "jdbc:sqlite";
        String dbUrl = driverName + ":" + dbName;

        Connection establishedConnection = DriverManager.getConnection(dbUrl);
        
        return establishedConnection;
    }

}
