package com.pwr.lab8.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.pwr.lab8.connection.CreateConnectionToDB;
import com.pwr.lab8.model.Car;


public class SelectQueries {

    private static final String SELECT_ALL = "SELECT * from car"; 
            
            //"CREATE TABLE IF NOT EXISTS car (id INTEGER primary key autoincrement, number varchar(10), reservation intger)";
//    String sMakeInsert = "INSERT INTO car (number, reservation) VALUES('asd123', 1)";
//    String sMakeSelect = "SELECT * from car";
    
    private CreateConnectionToDB connector = new CreateConnectionToDB();
    private Connection connection;
    
    
    public SelectQueries() {
        try {
            connection = connector.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getAllCarsFromDb() throws SQLException {
        Statement statement = connection.createStatement();
        
        try {
            
            try {
                ResultSet rs = statement.executeQuery(SELECT_ALL);
                return rs;
            } finally {
                try {
                    statement.close();
                } catch (Exception ignore) {
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ignore) {
            }
        }
        
    }
}
