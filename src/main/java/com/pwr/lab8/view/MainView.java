package com.pwr.lab8.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import com.pwr.lab8.connection.CreateConnectionToDB;
import com.pwr.lab8.queries.DeleteQuery;
import com.pwr.lab8.queries.InsertQueries;
import com.pwr.lab8.queries.SelectQueries;


public class MainView extends JFrame {

    private static final long serialVersionUID = 1811093659208014030L;

    private Random rand = new Random();

    private JButton ranking = new JButton("Rank");
    private JButton makeInsert = new JButton("Insert");
    private JButton refresh = new JButton("Refresh");
    private JButton delete = new JButton("Delete");
    private JButton rankingYear = new JButton("Rank year");

    private InsertQueries insert;
    private SelectQueries select;
    private DeleteQuery deleteQ;

    private JDatePickerImpl datePicker;

    private List<String> listOfAllRegistrations = new ArrayList<>();

    private CreateConnectionToDB connector;

    private JTable table = new JTable();
    private DefaultTableModel tableModel;

    private JTextArea registryNo = new JTextArea("Nr rejestracji");
    private JTextArea name = new JTextArea("Nazwisko");

    private JList<String> langs = new JList<String>(new String[] { "English", "Polski", "Espanol" });

    private static String[] TABLE_COLUMNS = { "id", "nazwisko", "data rezerwacji", "numer rejestracyjny", "koszt" };

    private Locale loc;
    private ResourceBundle messages;


    public MainView(CreateConnectionToDB connector) {
        super("Głowne okno");

        tableModel = (DefaultTableModel) table.getModel();
        tableModel.setColumnIdentifiers(TABLE_COLUMNS);

        this.connector = connector;

        insert = new InsertQueries(connector);
        select = new SelectQueries(connector);
        deleteQ = new DeleteQuery(connector);
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel);

        add(datePicker);
        add(registryNo);
        add(name);

        add(langs);

        add(ranking);
        add(rankingYear);
        add(makeInsert);
        add(refresh);
        add(delete);

        JScrollPane scroll = new JScrollPane(table);
        add(scroll);

        setLayout(new FlowLayout());
        setSize(new Dimension(500, 500));
        setVisible(true);

        setListeners();
    }

    private void setListeners() {
        makeInsert.addActionListener(l -> {
            try {
                String selectedDate = getDate();

                if (!checkIfReservationExists(selectedDate)) {
                    insert.insertIntoCarTable(name.getText(), selectedDate, registryNo.getText(), rand.nextInt(20) + 2);
                } else {
                    JOptionPane.showMessageDialog(null, "Rezerwacja na tą datę już istnieje !!!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        rankingYear.addActionListener(l -> {
            new YearStatsView(connector, 1900 + (new Date()).getYear());
        });

        langs.addListSelectionListener(l -> {

            switch (langs.getSelectedValue()) {
            case "Polski":
                loc = new Locale("en", "US");
                break;
            case "English":
                loc = new Locale("pl", "PL");
                break;
            case "Espanol":
                loc = new Locale("es", "ES");
                break;
            }

            messages = ResourceBundle.getBundle("MessagesBundle", loc);

            TABLE_COLUMNS = new String[] {"id", messages.getString("Name"),
                    messages.getString("Reservation"), 
                    messages.getString("Number"),
                    messages.getString("Cost")};

            tableModel.setColumnIdentifiers(TABLE_COLUMNS);
            
            delete.setText(messages.getString("Delete"));
            ranking.setText(messages.getString("Rank"));
            makeInsert.setText(messages.getString("Insert"));
            refresh.setText(messages.getString("Refresh"));
            rankingYear.setText(messages.getString("Rankyear"));

        });

        ranking.addActionListener(listener -> {
            try {
                new StatsView(connector, (new Date()).getMonth());
            } catch (Exception e) {
                System.err.println("Problem z nawiazaniem polaczenia");
                e.printStackTrace();
            }
        });

        refresh.addActionListener(l -> {
            tableModel.setRowCount(0);

            Object[] objects = new Object[TABLE_COLUMNS.length];

            ResultSet rs;
            try {
                rs = select.getAllCarsFromDb();
                while (rs.next())
                {
                    for (int i = 0; i < TABLE_COLUMNS.length; i++) {
                        objects[i] = rs.getObject(i + 1);
                    }
                    tableModel.addRow(objects);
                    listOfAllRegistrations.add(rs.getString("id"));
                }
                table.setModel(tableModel);
                table.repaint();
                table.updateUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        delete.addActionListener(l -> {
            int selectedRow = table.getSelectedRow();

            String id = listOfAllRegistrations.get(selectedRow);

            try {
                deleteQ.deleteFromCar(Integer.valueOf(id));
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    private boolean checkIfReservationExists(String selectedDate) throws SQLException {
        return select.checkIfReservationExists(selectedDate);
    }

    private String getDate() {
        Date selectedDate = (Date) datePicker.getModel().getValue();

        StringBuilder date = new StringBuilder();
        date.append(selectedDate.getDay());
        date.append("-");
        date.append(selectedDate.getMonth() + 1);
        date.append("-");
        date.append(1900 + selectedDate.getYear());

        return date.toString();
    }

}
