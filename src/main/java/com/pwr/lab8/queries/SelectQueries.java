package com.pwr.lab8.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pwr.lab8.connection.CreateConnectionToDB;


public class SelectQueries {

    public static final String SELECT_ALL = "SELECT * from car;";
    public static final String SELECT_BY_DATE = "SELECT * FROM car WHERE date = ?;";
    public static final String SELECT_COST_SUM = "SELECT id, name, SUM (cost) AS sum FROM car WHERE date LIKE '%-"; 
    public static final String SELECT_COST_END = "-%' GROUP BY name ORDER BY sum DESC LIMIT 10;";  

    public static final String SELECT_COST_SUM_YEAR = "SELECT id, name, SUM (cost) AS sum FROM car WHERE date LIKE '%-"; 
    public static final String SELECT_COST_END_YEAR = "%' GROUP BY name ORDER BY sum DESC LIMIT 10;";  
    
    private Connection connection;

    public SelectQueries(CreateConnectionToDB connector) {
        try {
            this.connection = connector.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Nie udało się utworzyć połączenia");
            e.printStackTrace();
        }
    }

    public ResultSet getAllCarsFromDb() throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet allRowsFromCar = statement.executeQuery(SELECT_ALL);
        return allRowsFromCar;

    }
    
    public ResultSet getRank(int month) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_COST_SUM + ++month + SELECT_COST_END);
        
        ResultSet allRowsFromCar = statement.executeQuery();
        
        return allRowsFromCar;
    }

    public ResultSet getYearRank(int year) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_COST_SUM_YEAR + year + SELECT_COST_END_YEAR);
        
        ResultSet allRowsFromCar = statement.executeQuery();
        
        
        return allRowsFromCar;
    }

    public boolean checkIfReservationExists(String date) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_BY_DATE);

        statement.setString(1, date);
        
        ResultSet allRowsFromCar = statement.executeQuery();
        return allRowsFromCar.next();

    }
}
