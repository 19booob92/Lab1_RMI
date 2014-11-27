package ModelComponents;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JTextArea;

public class CarModelView extends JComponent{

    private static final long serialVersionUID = -884941233705395114L;
    
    private JTextArea id;
    private JTextArea number;
    private JTextArea reservation;

    public CarModelView(long id, String number, long reservation) {
        this.id = new JTextArea(String.valueOf(id));
        this.number = new JTextArea(number);
        this.reservation = new JTextArea(String.valueOf(reservation));
        
        setSize(new Dimension(500,500));
        setVisible(true);
        
    }

    public JTextArea getId() {
        return id;
    }


    public void setId(JTextArea id) {
        this.id = id;
    }


    public JTextArea getNumber() {
        return number;
    }


    public void setNumber(JTextArea number) {
        this.number = number;
    }


    public JTextArea getReservation() {
        return reservation;
    }


    public void setReservation(JTextArea reservation) {
        this.reservation = reservation;
    }
}
