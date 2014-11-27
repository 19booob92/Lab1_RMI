function doFilter(image) {

	var height = image.getHeight();
	var width = image.getWidth();

	var i = 0;
	var j = 0;
	
	for (i = 0; i < width; i++) {
		for (j = 0; j < height; j++) {
			var rgb = image.getRGB(i, j);
			
			var color = new java.awt.Color(rgb);
			
			
			var editedColot = new java.awt.Color((color.getRed()) / 400, (color.getGreen()) / 400, (color.getBlue()) / 400, 0.8);
			image.setRGB(i, j, editedColot.getRGB());
		}
	}
	return image;
}
