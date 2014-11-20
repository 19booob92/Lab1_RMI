package View;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.script.ScriptException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import FilterStrategy.Filtering;

public class MainView extends JFrame {

	private Filtering filtering = new Filtering();

	private JList list;;
	final JPanel panel = new JPanel();
	
	private JFileChooser fileChooser = new JFileChooser();

	private ImageIcon image;

	public MainView() {
		super("Filtering");

		getContentPane().setLayout(null);

		setFilterList("/home/booob/workspace/GraphicModifier/src/js/");

		JButton btnChoo = new JButton("Apply filter");
		btnChoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					filtering.setJsFilter(list.getSelectedValue().toString());
					panel.add(new JLabel(filtering.getImageWithFilter(image)));
				} catch (IOException | NoSuchMethodException | ScriptException e) {
					e.printStackTrace();
				}
				panel.updateUI();
				panel.repaint();
				repaint();
			}
		});
		btnChoo.setBounds(44, 283, 117, 25);
		getContentPane().add(btnChoo);

		list.setBounds(44, 47, 1, 1);
		list.setSize(100, 200);
		getContentPane().add(list);

		panel.setBounds(173, 49, 425, 371);
		getContentPane().add(panel);

		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fileChooser.showOpenDialog(MainView.this);

				image = new ImageIcon(fileChooser.getSelectedFile()
						.getAbsolutePath());
				panel.add(new JLabel(image));
				panel.updateUI();
				panel.repaint();
				repaint();
			}
		});

		btnLoad.setBounds(214, 12, 117, 25);
		getContentPane().add(btnLoad);

		setSize(602, 505);
		setVisible(true);
	}

	private void setFilterList(String path) {
		ArrayList<String> filterFiles = new ArrayList<String>();
		File folder = new File(path);
		for (File fileEntry : folder.listFiles()) {
			filterFiles.add(fileEntry.getName());
		}
		System.err.println(filterFiles);
		list = new JList<>(filterFiles.toArray());
	}
}
