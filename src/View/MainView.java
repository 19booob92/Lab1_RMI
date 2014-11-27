package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.script.ScriptException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import FilterStrategy.Filtering;

public class MainView extends JFrame {

	private static final long serialVersionUID = -3478522286763207197L;

	private Filtering filtering = new Filtering();

	private JList list;
	final JPanel panel = new JPanel();

	private JFileChooser fileChooser = new JFileChooser();

	private BufferedImage image;
	private Preferences prefs;

	private static final String CHOOSEN_FILTER = "filterName";
	private String defaultSelected = "blue.js";

	public MainView() {
		super("Filtering");

		prefs = Preferences.userNodeForPackage(MainView.class);

		getContentPane().setLayout(null);

		setFilterList("/home/booob/workspace/GraphicModifier/src/js/");

		FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
				"jpg", "jpeg", "png", "ico");

		fileChooser.setFileFilter(imageFilter);

		JButton btnChoo = new JButton("Apply filter");
		btnChoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					filtering.setJsFilter(list.getSelectedValue().toString());

					image = filtering.getImageWithFilter(image);

					refresh();
					panel.add(new JLabel(new ImageIcon(image)));
					refresh();
				} catch (IOException | NoSuchMethodException | ScriptException e) {
					e.printStackTrace();
				}

			}
		});
		btnChoo.setBounds(22, 284, 117, 25);
		getContentPane().add(btnChoo);

		list.setBounds(22, 31, 150, 200);
		list.setSize(100, 200);
		getContentPane().add(list);

		panel.setBounds(173, 49, 425, 371);
		getContentPane().add(panel);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (list.getSelectedValue() != null) {
					prefs.put(CHOOSEN_FILTER, list.getSelectedValue()
							.toString());
				}
				System.exit(0);
			}
		});

		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				fileChooser.showOpenDialog(MainView.this);

				File imageFile = new File(fileChooser.getSelectedFile()
						.getAbsolutePath());

				try {
					image = ImageIO.read(imageFile);
					panel.removeAll();
				} catch (IOException e) {
					e.printStackTrace();
				}

				ImageIcon icon = new ImageIcon(image);
				panel.add(new JLabel(icon));

				refresh();
			}
		});

		btnLoad.setBounds(22, 247, 117, 25);
		getContentPane().add(btnLoad);

		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File imageFile = new File(fileChooser.getSelectedFile()
						.getAbsolutePath());
				try {
					image = ImageIO.read(imageFile);
					panel.removeAll();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				panel.add(new JLabel(new ImageIcon(image)));
				refresh();
			}

		});
		btnNewButton.setBounds(22, 321, 117, 25);
		getContentPane().add(btnNewButton);

		setSize(602, 505);
		setVisible(true);
	}

	private void refresh() {
		panel.updateUI();
		panel.repaint();
		repaint();
	}

	private void setFilterList(String path) {
		ArrayList<String> filterFiles = new ArrayList<String>();
		File folder = new File(path);
		for (File fileEntry : folder.listFiles()) {

			Pattern pattern = Pattern.compile(".js$");
			Matcher matcher = pattern.matcher(fileEntry.getName());
			if (matcher.find()) {
				filterFiles.add(fileEntry.getName());
			}
		}
		list = new JList<>(filterFiles.toArray());

		defaultSelected = prefs.get(CHOOSEN_FILTER, defaultSelected);
		System.err.println(defaultSelected);
		int index = 0;

		for (String filterName : filterFiles) {
			if (filterName.equals(defaultSelected)) {
				list.setSelectedIndex(index);
			}
			index++;
		}
	}
}
