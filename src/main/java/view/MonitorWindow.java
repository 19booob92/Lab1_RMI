package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import mainPack.IMonitor;
import mainPack.MonitorImpl;


public class MonitorWindow extends JFrame {

    private static final long serialVersionUID = 1112312312L;

    private IMonitor monitor;

    private JButton createMonitorBtn;

    public MonitorWindow() {
        super("Monitor");

        setSize(new Dimension(100, 100));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());

        createMonitorBtn = new JButton("Run !");

        add(createMonitorBtn);
    }
    
    private void setListeners() {
        createMonitorBtn.addActionListener(l -> {
            try {
                monitor = new MonitorImpl("192.168.0.1", 8080);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }});
    }
}
