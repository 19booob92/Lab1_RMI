package mainViewPack;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainCassino extends JFrame{

    private static final long serialVersionUID = -3890396444192573819L;

    private JTextArea percent1 = new JTextArea("%");
    private JTextArea percent2 = new JTextArea("%");
    private JTextArea percent3 = new JTextArea("%");
    private JTextArea percent4 = new JTextArea("%");
    private JTextArea percent5 = new JTextArea("%");
    
    private JTextArea timeout1 = new JTextArea("s");
    private JTextArea timeout2 = new JTextArea("s");
    private JTextArea timeout3 = new JTextArea("s");
    private JTextArea timeout4 = new JTextArea("s");
    private JTextArea timeout5 = new JTextArea("s");
    
    private JButton apply = new JButton("apply");
    
    public MainCassino() {
        super("Cassino");
        
        setLayout(new FlowLayout());
        add(percent1);
        add(percent2);
        add(percent3);
        add(percent4);
        add(percent5);

        add(timeout1);
        add(timeout2);
        add(timeout3);
        add(timeout4);
        add(timeout5);
        
        add(apply);
    }
    
}
