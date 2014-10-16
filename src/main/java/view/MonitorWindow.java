package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import mainPack.IMonitor;
import mainPack.MonitorImpl;


public class MonitorWindow extends SuperView {

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

        registerBtn = new JButton("register");
        unregisterBtn = new JButton("unregister");
        refreshBtn = new JButton("refresh");
        
        add(createMonitorBtn);

        setVisible(true);
    }

    private void setListeners() {
        createMonitorBtn.addActionListener(l -> {
            String ip = ipTA.getText();
            int portNo = Integer.valueOf(portTA.getText());
            try {
                monitor = new MonitorImpl(ip, portNo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        this.refreshBtn.addActionListener(l -> {
            try {
                monitor.change();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        this.registerBtn.addActionListener(l -> {
            try {
                monitor.register();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        this.registerBtn.addActionListener(l -> {
            try {
                monitor.unregister();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        
    }
}
