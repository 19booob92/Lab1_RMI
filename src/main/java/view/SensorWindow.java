package view;

import javax.swing.JButton;

import mainPack.ISensor;
import mainPack.SensorImpl;


public class SensorWindow extends SuperView {

    private static final long serialVersionUID = 1L;

    private ISensor sensor;

    private JButton createSensorBtn;
    private JButton startBtn;
    private JButton stopBtn;

    public SensorWindow() {
        super("Sensor");

        createSensorBtn = new JButton("Add sens");

        startBtn = new JButton("start");
        stopBtn = new JButton("stop");
        registerBtn = new JButton("register");
        unregisterBtn = new JButton("unregister");
        refreshBtn = new JButton("refresh");
        
        add(createSensorBtn);
        add(startBtn);
        add(stopBtn);
        add(refreshBtn);
        add(registerBtn);
        add(unregisterBtn);

        setVisible(true);

        initListeners();
    }

    private void initListeners() {
        createSensorBtn.addActionListener(l -> {
            System.out.println("Uruchomiono");

            String ip = ipTA.getText();
            int portNo = Integer.valueOf(portTA.getText());
            try {
                sensor = new SensorImpl(ip, portNo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        startBtn.addActionListener(l -> {
            try {
                sensor.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        stopBtn.addActionListener(l -> {
            try {
                sensor.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        this.refreshBtn.addActionListener(l -> {
            try {
                sensor.stateChange();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        this.registerBtn.addActionListener(l -> {
            try {
                sensor.register();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        this.unregisterBtn.addActionListener(l -> {
            try {
                sensor.unregister();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
