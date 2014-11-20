package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Window extends JComponent implements WindowMBean {
	private static final long serialVersionUID = 17986519198453187L;

	private final String name = "Bean";

	private int timeout = 0;

	private Runnable timer;

	private JTextArea wind = new JTextArea("XXX");
	private JButton windBtn = new JButton("Run!!");
	private int[] values = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

	private volatile boolean isRunned = false;

	private Random rand = new Random();

	public Window() {
		setSize(121, 100);
		setLayout(null);
		wind.setBounds(35, 5, 51, 30);
		add(wind);
		windBtn.setBounds(25, 40, 71, 25);
		add(windBtn);

		setVisible(true);

		timer = new Runnable() {

			@Override
			public void run() {
				int time = 0;
				while (time < timeout) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					time++;
				}
				isRunned = false;
			}

		};

		Runnable threadInner = new Runnable() {

			@Override
			public void run() {
				int i = 0;
				int valToShow = 0;
				while (true) {
					try {
						while (true) {

							Thread.sleep(800);
							if (isRunned == false) {
								break;
							}
							wind.setText(String.valueOf(getRandomValue()));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			private int getRandomValue() {
				int i;
				int valToShow = 0;
				i = rand.nextInt(100);
				int sum = 0;
				if (i < (sum += values[0])) {
					valToShow = 0;
				} else if (i < (sum += values[1])) {
					valToShow = 1;
				} else if (i < (sum += values[2])) {
					valToShow = 2;
				} else if (i < (sum += values[3])) {
					valToShow = 3;
				} else if (i < (sum += values[4])) {
					valToShow = 4;
				} else if (i < (sum += values[5])) {
					valToShow = 5;
				} else if (i < (sum += values[6])) {
					valToShow = 6;
				} else if (i < (sum += values[7])) {
					valToShow = 7;
				} else if (i < (sum += values[8])) {
					valToShow = 8;
				} else if (i < (sum += values[9])) {
					valToShow = 9;
				}
				return valToShow;
			};
		};

		Thread t = new Thread(threadInner);
		t.start();

		wind.setFont(new Font("asd", 2, 25));

		windBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread t2 = new Thread(timer);
				t2.start();

				if (wind.getText().equals("0")) {
					new JOptionPane().showMessageDialog(null, "Wygrałeś !!!");
				}
				isRunned = !isRunned;
				if (isRunned == true) {
					windBtn.setText("Stop !");
				} else if (isRunned == false) {
					windBtn.setText("Start !");
				}
			}
		});
	}

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

	@Override
	public void make() {
		windBtn.doClick();
		repaint();
	}

	@Override
	public String getName() {
		return this.name;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
		this.updateUI();
	}
}
