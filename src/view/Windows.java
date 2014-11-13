package view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Windows extends JFrame {


    private static final long serialVersionUID = 17986519198453187L;

    private JTextArea wind = new JTextArea("XXX");
    private JButton windBtn = new JButton("Run!!");
    private int[] values = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    private volatile boolean isRunned = false;

    public Windows() {
        super("Gra");

        setLayout(new FlowLayout());
        setSize(65, 100);
        add(wind);
        add(windBtn);

        setVisible(true);

        Runnable threadInner = () -> {
            while (true) {
                     
                    try {
                        for (int i = 0; i < values.length; i++) {
                            Thread.sleep(800);
                            if (i == 9) {
                                i = 0;
                            }
                            if (isRunned == false) {
                                break;
                            }
                            wind.setText(String.valueOf(values[i]));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        };

        Thread t = new Thread(threadInner);
        t.start();

        wind.setFont(new Font("asd", 2, 25));
        
        windBtn.addActionListener(l -> {
            isRunned = !isRunned;
        });

    };

    public JTextArea getWind() {
        return wind;
    }


    public void setWind(JTextArea wind) {
        this.wind = wind;
    }


    public JButton getWindBtn() {
        return windBtn;
    }


    public void setWindBtn(JButton windBtn) {
        this.windBtn = windBtn;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
    public int[] getValues() {
        return values;
    }

    
    public void setValues(int[] values) {
        this.values = values;
    }

    
    public boolean isRunned() {
        return isRunned;
    }

    
    public void setRunned(boolean isRunned) {
        this.isRunned = isRunned;
    }
}
