package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class SuperView extends JFrame {

    private static final long serialVersionUID = 3405432966344464354L;
    
    protected JTextArea ipTA;
    protected JTextArea portTA;

    protected JButton registerBtn;
    protected JButton unregisterBtn;
    
    public SuperView(String name) {
        super(name);
        
        setSize(new Dimension(200, 200));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        
        portTA = new JTextArea("PORT");
        ipTA = new JTextArea("IP");
        
        add(portTA);
        add(ipTA);

    }
    
}
