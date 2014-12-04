package com.pwr.lab8.queries;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pwr.lab8.connection.CreateConnectionToDB;


public class DeleteQuery {

    private Connection connection;

    public static final String DELETE_BY_ID = "DELETE FROM car WHERE id = ?;";

    public DeleteQuery(CreateConnectionToDB connector) {
        try {
            this.connection = connector.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromCar(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);

        try {
            statement.setInt(1, id);
            
            statement.executeUpdate();
        } finally {
            try {
                statement.close();
            } catch (Exception ignore) {
            }
        }

    }

}
