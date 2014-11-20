package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainV extends JFrame implements MainVMBean {

	private static final long serialVersionUID = -4949049288618757818L;

	Window w1 = new Window();
	Window w2 = new Window();
	Window w3 = new Window();
	Window w4 = new Window();
	Window w5 = new Window();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JButton btnRefresh;

	private final String name = "MainViewCasino";
	private JTextField textField_10;

	public MainV() throws MalformedObjectNameException,
			InstanceAlreadyExistsException, MBeanRegistrationException,
			NotCompliantMBeanException {
		super("Casino");

		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("View:type=Window");
		ObjectName nameMainView = new ObjectName("View:type=MainV");

		mbs.registerMBean(w1, name);
		mbs.registerMBean(w2, new ObjectName("View:type=window2"));
		mbs.registerMBean(w3, new ObjectName("View:type=window3"));
		mbs.registerMBean(w4, new ObjectName("View:type=exampl"));
		mbs.registerMBean(w5, new ObjectName("View:type=window5"));

		mbs.registerMBean(this, nameMainView);

		setSize(new Dimension(500, 500));
		getContentPane().setLayout(null);
		w2.setBounds(162, 12, 106, 84);
		getContentPane().add(w2);
		w1.setBounds(35, 12, 124, 84);
		getContentPane().add(w1);
		w3.setBounds(35, 102, 124, 72);
		getContentPane().add(w3);
		w4.setBounds(172, 108, 106, 84);
		getContentPane().add(w4);
		w5.setBounds(111, 177, 106, 84);
		getContentPane().add(w5);

		textField = new JTextField();
		textField.setBounds(318, 12, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(318, 44, 114, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(318, 77, 114, 19);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(318, 115, 114, 19);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(318, 146, 114, 19);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(318, 173, 114, 19);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);

		JLabel label = new JLabel("0");
		label.setBounds(280, 14, 70, 15);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("1");
		label_1.setBounds(280, 41, 70, 15);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("2");
		label_2.setBounds(280, 68, 70, 15);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("3");
		label_3.setBounds(280, 117, 70, 15);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("4");
		label_4.setBounds(280, 146, 70, 15);
		getContentPane().add(label_4);

		JLabel label_5 = new JLabel("5");
		label_5.setBounds(280, 177, 70, 15);
		getContentPane().add(label_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(318, 204, 114, 19);
		getContentPane().add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(318, 235, 114, 19);
		getContentPane().add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(318, 262, 114, 19);
		getContentPane().add(textField_8);

		JLabel label_6 = new JLabel("6");
		label_6.setBounds(280, 206, 70, 15);
		getContentPane().add(label_6);

		JLabel label_7 = new JLabel("7");
		label_7.setBounds(280, 235, 70, 15);
		getContentPane().add(label_7);

		JLabel label_8 = new JLabel("8");
		label_8.setBounds(280, 266, 70, 15);
		getContentPane().add(label_8);

		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(146, 315, 117, 25);
		getContentPane().add(btnRefresh);

		JLabel label_9 = new JLabel("9");
		label_9.setBounds(280, 296, 70, 15);
		getContentPane().add(label_9);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(318, 292, 114, 19);
		getContentPane().add(textField_9);

		textField_10 = new JTextField();
		textField_10.setBounds(318, 373, 114, 19);
		getContentPane().add(textField_10);
		textField_10.setColumns(10);

		JLabel lblTimeout = new JLabel("TimeOut");
		lblTimeout.setBounds(344, 345, 70, 15);
		getContentPane().add(lblTimeout);

		JButton btnSetTimeout = new JButton("Set timeout");
		btnSetTimeout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				w1.setTimeout(Integer.parseInt(textField_10.getText()));
				w2.setTimeout(Integer.parseInt(textField_10.getText()));
				w3.setTimeout(Integer.parseInt(textField_10.getText()));
				w4.setTimeout(Integer.parseInt(textField_10.getText()));
				w5.setTimeout(Integer.parseInt(textField_10.getText()));
			}
		});
		btnSetTimeout.setBounds(315, 411, 117, 25);
		getContentPane().add(btnSetTimeout);

		btnRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[] values = { Integer.parseInt(textField.getText()),
						Integer.parseInt(textField_1.getText()),
						Integer.parseInt(textField_2.getText()),
						Integer.parseInt(textField_3.getText()),
						Integer.parseInt(textField_4.getText()),
						Integer.parseInt(textField_5.getText()),
						Integer.parseInt(textField_6.getText()),
						Integer.parseInt(textField_7.getText()),
						Integer.parseInt(textField_8.getText()),
						Integer.parseInt(textField_9.getText()) };

				w1.setValues(values);
				w2.setValues(values);
				w3.setValues(values);
				w4.setValues(values);
				w5.setValues(values);
			}

		});

		setVisible(true);
	}

	static public int getIntFromTextFieldText(JTextField tf) {
		return Integer.getInteger(tf.getText());
	}

	@Override
	public void refreshAllAA() {
		btnRefresh.doClick();
	}

	@Override
	public String getName() {
		return this.name;
	}

	public Window getW1() {
		return w1;
	}

	public void setW1(Window w1) {
		this.w1 = w1;
	}

	public Window getW2() {
		return w2;
	}

	public void setW2(Window w2) {
		this.w2 = w2;
	}

	public Window getW3() {
		return w3;
	}

	public void setW3(Window w3) {
		this.w3 = w3;
	}

	public Window getW4() {
		return w4;
	}

	public void setW4(Window w4) {
		this.w4 = w4;
	}

	public Window getW5() {
		return w5;
	}

	public void setW5(Window w5) {
		this.w5 = w5;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
	}

	public JTextField getTextField_6() {
		return textField_6;
	}

	public void setTextField_6(JTextField textField_6) {
		this.textField_6 = textField_6;
	}

	public JTextField getTextField_7() {
		return textField_7;
	}

	public void setTextField_7(JTextField textField_7) {
		this.textField_7 = textField_7;
	}

	public JTextField getTextField_8() {
		return textField_8;
	}

	public void setTextField_8(JTextField textField_8) {
		this.textField_8 = textField_8;
	}

	public JTextField getTextField_9() {
		return textField_9;
	}

	public void setTextField_9(JTextField textField_9) {
		this.textField_9 = textField_9;
	}

	public JButton getBtnRefresh() {
		return btnRefresh;
	}

	public void setBtnRefresh(JButton btnRefresh) {
		this.btnRefresh = btnRefresh;
	}

	@Override
	public String getTextFieldText() {
		return textField.getText();
	}

	@Override
	public void setTextFieldText(String texttField) {
		textField.setText(texttField);
		textField.updateUI();
		repaint();
	}

	@Override
	public String getTextFieldText_1() {
		return textField_1.getText();
	}

	@Override
	public void setTextFieldText_1(String textField) {
		textField_1.setText(textField);
		textField_1.updateUI();
		repaint();
	}

	@Override
	public String getTextFieldText_2() {
		return textField_2.getText();
	}

	@Override
	public void setTextFieldText_2(String textField) {
		textField_2.setText(textField);
		textField_2.updateUI();
		repaint();
	}

	@Override
	public String getTextFieldText_3() {
		return textField_3.getText();
	}

	@Override
	public void setTextFieldText_3(String textField) {
		textField_3.setText(textField);
		textField_3.updateUI();
		repaint();
	}

	@Override
	public String getTextFieldText_4() {
		return textField_4.getText();
	}

	@Override
	public void setTextFieldText_4(String textField) {
		textField_4.setText(textField);
		textField_4.updateUI();
		repaint();
	}

	@Override
	public String getTextFieldText_5() {
		return textField_5.getText();
	}

	@Override
	public void setTextFieldText_5(String textField) {
		textField_5.setText(textField);
		textField_5.updateUI();
		repaint();
	}

	@Override
	public String getTextFieldText_6() {
		return textField_6.getText();
	}

	@Override
	public void setTextFieldText_6(String textField) {
		textField_6.setText(textField);
		textField_6.updateUI();
		repaint();
	}

	@Override
	public String getTextFieldText_7() {
		return textField_7.getText();
	}

	@Override
	public void setTextFieldText_7(String textField) {
		textField_7.setText(textField);
		textField_7.updateUI();
		repaint();
	}

	@Override
	public String getTextFieldText_8() {
		return textField_8.getText();
	}

	@Override
	public void setTextFieldText_8(String textxField) {
		textField_8.setText(textxField);
		textField_8.updateUI();
		repaint();
	}

	@Override
	public String getBtnRefresh_9() {
		return textField_9.getText();
	}

	@Override
	public void setBtnRefresh_9(String btnRefresh) {
		textField_9.setText(btnRefresh);
		textField_9.updateUI();
		repaint();
	}

	public String getTextField_10() {
		return textField_10.getText();
	}

	public void setTextField_10(String textField_10Value) {
		this.textField_10.setText(textField_10Value);
		this.textField_10.updateUI();
		
	}

}
