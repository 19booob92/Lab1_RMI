function doFilter(image) {

	var height = image.getHeight();
	var width = image.getWidth();

	var i = 0;
	var j = 0;
	
	for (i = 0; i < width; i++) {
		for (j = 0; j < height; j++) {
			var rgb = image.getRGB(i, j);
			
			var color = new java.awt.Color(rgb);
			
			if (color.getRed() < 100 && color.getGreen() > 80 && color.getBlue() < 50) {
			} else {
				var greyScale = (color.getRed() * 0.21) + (color.getGreen() * 0.72) 
					+ (color.getBlue() * 0.07);
				var editedColot = new java.awt.Color(greyScale / 255, greyScale / 255, greyScale / 255, 0.5);
				image.setRGB(i, j, editedColot.getRGB());
			}
			
		}
	}
	return image;
}
