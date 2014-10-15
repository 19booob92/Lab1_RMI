package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import mainPack.ISensor;


public class SensorWindow extends JFrame{

    private static final long serialVersionUID = 1L;
    
    private ISensor sensor;

    private JButton createSensorBtn;

    public SensorWindow() {
        super("Sensor");

        setSize(new Dimension(200, 200));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());

        createSensorBtn = new JButton("Add sens");

        add(createSensorBtn);

        initListeners();
    }

    private void initListeners() {
        createSensorBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Uruchomiono");
            }
        });
    }
}
