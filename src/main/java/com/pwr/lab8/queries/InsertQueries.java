package com.pwr.lab8.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pwr.lab8.connection.CreateConnectionToDB;


public class InsertQueries {

    private Connection connection;

    public static final String INSERT_INTO_CAR = "INSERT INTO car (name, date, number, cost) VALUES(?,?,?, ?);";

    public InsertQueries(CreateConnectionToDB connector) {
        try {
            this.connection = connector.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoCarTable(String name, String date, String registry, int cost) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_INTO_CAR);

        try {
            statement.setString(1, name);
            statement.setString(2, date);
            statement.setString(3, registry);
            statement.setInt(4, cost);
            
            statement.executeUpdate();
          
        } catch(SQLException ex) {
            statement.close();
        }
            finally {
        }
            try {
                statement.close();
            } catch (Exception ignore) {
            }
        }

    public void insertIntoStats(String name, int cost) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_INTO_CAR);

        try {
            statement.setString(1, name);
            statement.setInt(2, cost);
            
        } catch(SQLException ex) {
            statement.close();
        }
            finally {
        }
            try {
                statement.close();
            } catch (Exception ignore) {
            }
        }

    
}
