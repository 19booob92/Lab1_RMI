package com.pwr.lab8.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import ModelComponents.CarModelView;

import com.pwr.lab8.model.Car;
import com.pwr.lab8.service.CarService;
import com.pwr.lab8.service.CarServiceImpl;


public class MainView extends JFrame {

    private static final long serialVersionUID = 1811093659208014030L;

    private JButton connectAndInsert = new JButton("Connect ");

    private CarService carService = new CarServiceImpl();

    private List<CarModelView> jTextAreas = new ArrayList<>();
    
    public MainView() {
        super("Głowne okno");

        add(connectAndInsert);
        
        setLayout(new FlowLayout());
        setSize(new Dimension(500, 500));
        setVisible(true);

        setListeners();
    }

    private void setListeners() {
        connectAndInsert.addActionListener(listener -> {
            try {
                List<Car> carList = carService.getAllCars();

                for (Car car : carList) {
                    jTextAreas.add(new CarModelView(car.getId(), car.getNumber(), car.getReservation()));
                }
                
                for (CarModelView carModelView : jTextAreas) {
                    MainView.this.add(carModelView);
                    MainView.this.repaint();
                }
            } catch (Exception e) {
                System.err.println("Problem z nawiazaniem polaczenia");
                e.printStackTrace();
            }
        });
    }

}
