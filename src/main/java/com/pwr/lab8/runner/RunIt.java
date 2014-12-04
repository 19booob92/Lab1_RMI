package com.pwr.lab8.runner;

import java.sql.SQLException;

import com.pwr.lab8.connection.CreateConnectionToDB;
import com.pwr.lab8.queries.CreateQueries;
import com.pwr.lab8.view.MainView;


public class RunIt {

    public static void main(String[] args) throws SQLException {
        CreateConnectionToDB connector = new CreateConnectionToDB();

        CreateQueries create = new CreateQueries(connector);
        create.createCarTable();
        
        new MainView(connector);
    }
}
