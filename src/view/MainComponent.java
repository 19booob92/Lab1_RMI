//package view;
//
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.jar.JarFile;
//
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//
//public class MainComponent extends JFrame{
//
//	private JarFile FFF;
//	
//	private static final long serialVersionUID = 11232131234L;
//	
//	private JButton ramBtn = new JButton("RAM");
//	private JButton cpuBtn = new JButton("CPU");
//	private JButton partsBtn = new JButton("PARTs");
//	
//	private JLabel cpuValue = new JLabel();
//	private JLabel ramValue = new JLabel();
//	private JComboBox<String> partitionsList;
//	
//	private float cpu = 0;
//	private float ram = 0;
//	private String [] partitions;
//	
//	public MainComponent() {
//		super();
//		
//		setLayout(new FlowLayout());
//		setVisible(true);
//		
//		add(ramBtn);
//		add(cpuBtn);
//		add(partsBtn);
//		
//		cpuBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
////				cpuValue.setText(FFF.getCpuInfo());
//			}
//		});
//		
//		ramBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
////				ramValue.setText(FFF.getRamInfo());
//			}
//		});
//		
//		partsBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				partitions = FFF.getPartitions();
//				partitionsList = new JComboBox<>(partitions);
//			}
//		});
//	}
//	
//	
//
//	
//	
//}
