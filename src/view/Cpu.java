package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Cpu extends JFrame{

	private native String getCpu();
	private native static String[] getFileS();
	private native int getBattery();
	private native String getMem();
	
	private JTextArea batt = new JTextArea("Bttery");
	private JButton battBtn = new JButton("get Batt");
	private JTextArea mem = new JTextArea("Memory");
	private JButton memBtn = new JButton("get mem");
	private JTextArea cpu = new JTextArea("Cpu");
	private JButton cpuBtn = new JButton("get cpu");
	private JButton fsBtn = new JButton("get fileSystemEntries");

	private JTextArea richEdit = new JTextArea();

	public Cpu() {
           super("DaneJNI");
           
           richEdit.setRows(15);
           richEdit.setSize(50, 50);
           
           add(batt);
           add(mem);
           add(cpu);
           add(battBtn);
           add(memBtn);
           add(cpuBtn);
           add(richEdit);
           add(fsBtn);
           
           
           battBtn.addActionListener(l -> {
               batt.setText(String.valueOf(getBattery()));
           });
           
           cpuBtn.addActionListener(l -> {
               cpu.setText(getCpu());
           });
           
           memBtn.addActionListener(l -> {
               mem.setText(getMem());;
           });
           
           fsBtn.addActionListener(l -> {
               String[] entriesFromFS = getFileS();
               for (int i = 0; i < entriesFromFS.length-1; i++ ) {
                   richEdit.insert(entriesFromFS[i], i);
               }
           });
           
           setLayout(new FlowLayout());
           setSize(new Dimension(250,250));
           setVisible(true);
           
    }
	
	public static void main(String[] args) {
		
		System.load("/home/mateusz/git/Lab1_RMI/src/view/dll.so");
		Cpu cpu = new Cpu();
		
		System.out.println("Cpu info : " + cpu.getCpu());
		System.out.println("Bateria : " + cpu.getBattery() + " %");
		System.out.println("Pamiec : " + cpu.getMem() + " %");
		System.out.println("FileSys : " + cpu.getFileS()[1]);
		
		for (int i = 0; i < getFileS().length-1; i++ ) {
		    System.out.println("FileSys : " + getFileS()[i]);
        }
	}

}
