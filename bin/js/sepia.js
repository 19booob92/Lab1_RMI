function doFilter(image) {

	var height = image.getHeight();
	var width = image.getWidth();

	var i = 0;
	var j = 0;

	for (i = 0; i < width; i++) {
		for (j = 0; j < height; j++) {
			var rgb = image.getRGB(i, j);

			var color = new java.awt.Color(rgb);

			var outputRed = (color.getRed() * .393) + (color.getGreen() *.769) + (color.getBlue() * .389);
			var outputGreen = (color.getRed() * .349) + (color.getGreen() *.686) + (color.getBlue() * .168);
			var outputBlue = (color.getRed() * .272) + (color.getGreen() *.534) + (color.getBlue() * .131);

			var editedColot = new java.awt.Color(outputRed / 400, outputGreen / 350, outputBlue / 350, 1.);
			
			image.setRGB(i, j, editedColot.getRGB());
		}
	}
	return image;
}
