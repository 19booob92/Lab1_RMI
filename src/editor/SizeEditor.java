package editor;

import java.awt.Dimension;

public class SizeEditor extends ProperEditor{

	private Dimension dim = new Dimension(50, 50);

	@Override
	public String getAsText() {
		return "wys : "+ dim.getHeight() + "szer : " + dim.getWidth();
	}
	
	@Override
	public Object getValue() {
		return dim.getSize();
	}

	@Override
	public void setValue(Object value) {
		setDim((Dimension)value);
	}
	
	public Dimension getDim() {
		return dim;
	}

	public void setDim(Dimension dim) {
		this.dim = dim;
	}
	
}
