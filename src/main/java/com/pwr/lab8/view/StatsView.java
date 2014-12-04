package com.pwr.lab8.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pwr.lab8.connection.CreateConnectionToDB;
import com.pwr.lab8.queries.SelectQueries;


public class StatsView extends JFrame {
    
    private JTable table = new JTable();
    private DefaultTableModel tableModel;
    
    private static final String[] COLS = {"id", "user name", "TotalCost"}; 

    private SelectQueries select;
    
    private int month;
    
    public StatsView(CreateConnectionToDB connector, int month) {
        super("Stats");
    
        this.month = month;
        
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.setColumnIdentifiers(COLS);
        
        setLayout(new FlowLayout());
        setSize(new Dimension(500, 500));
        setVisible(true);
        
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        
        select = new SelectQueries(connector);
        
        tableModel.setRowCount(0);
        
        
        Object[] objects = new Object[COLS.length];

        ResultSet rs;
        try {
            rs = select.getRank(month);
            while (rs.next())
            {
                for (int i = 0; i < COLS.length; i++) {
                    objects[i] = rs.getObject(i + 1);
                }
                tableModel.addRow(objects);
            }
            table.setModel(tableModel);
            table.repaint();
            table.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
