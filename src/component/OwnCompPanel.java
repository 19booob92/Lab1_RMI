package component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.beans.*;

public class OwnCompPanel extends JPanel {

	private static final long serialVersionUID = 286796438088753134L;

	// simple properties
	private int width = 50;
	// indexed properties
	private String[] notes = new String[50];
	// bounded props
	private boolean change = false;
	// Constreined props
	private Color color;

	private JTextArea date = new JTextArea("DD-MM-RRRR");
	private JTextArea content = new JTextArea("Wprowadz tresc przypomnienia");
	private JButton add = new JButton("dodaj");

	private PropertyChangeSupport mPcs = new PropertyChangeSupport(this);
	private VetoableChangeSupport mVcs = new VetoableChangeSupport(this);

	public OwnCompPanel() {
		super();
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setSize(new Dimension(width, width));
		this.setBackground(Color.BLACK);

		add(date);
		add(content);
		add(add);
		
		this.addPropertyChangeListener("change", new PropertyListener());

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String[] getNotes() {
		return notes;
	}

	public void setNotes(String[] notes) {
		this.notes = notes;
	}

	public String getNotes(int idx) {
		return notes[idx];
	}

	public void setNotes(int idx, String content) {
		notes[idx] = content;
	}

	public boolean getchange() {
		return change;
	}

	public void setHeight(boolean change) {
		boolean oldChange = change;
		this.change = change;
		mPcs.firePropertyChange("change", oldChange, change);

	}

	public JTextArea getDate() {
		return date;
	}

	public void setDate(JTextArea date) {
		this.date = date;
	}

	public JTextArea getContent() {
		return content;
	}

	public void setContent(JTextArea content) {
		this.content = content;
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		mPcs.removePropertyChangeListener(listener);
	}

	@Override
	public void addVetoableChangeListener(VetoableChangeListener listener) {
		mVcs.addVetoableChangeListener(listener);
	}

	@Override
	public void removeVetoableChangeListener(VetoableChangeListener listener) {
		mVcs.removeVetoableChangeListener(listener);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) throws PropertyVetoException {
		Color oldColor = this.color;
		mVcs.fireVetoableChange("objColor", oldColor, color);
		this.color = color;
		mPcs.firePropertyChange("objColor", oldColor, color);
	}
	
	public void notifyWhenAboutEvent() {
		
	}
	
	private class PropertyListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent arg0) {
			if (arg0.getPropertyName().equals("change")) {
				OwnCompPanel.this.notifyWhenAboutEvent();
				JOptionPane.showMessageDialog(null, OwnCompPanel.this.getContent().getText());
			}
		}
		
	}

}
