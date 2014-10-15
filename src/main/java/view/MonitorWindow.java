package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import mainPack.IMonitor;


public class MonitorWindow extends JFrame {

    private static final long serialVersionUID = 1112312312L;

    private IMonitor monitor;

    private JButton createSensorBtn;

    public MonitorWindow() {
        super("Monitor");

        setSize(new Dimension(100, 100));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());

        createSensorBtn = new JButton("Add sens");

        add(createSensorBtn);
    }
}
