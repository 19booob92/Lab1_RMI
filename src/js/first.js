function doFilter(image) {

	var myImage = document.getElementById('myimage');
	var myCanvas = document.getElementById('mycanvas');
	var ctx = myCanvas.getContext('2d');
	ctx.drawImage(myImage, 0, 0);

	var myDataURL = myCanvas.toDataURL('image/png');

	var myBase64Data = myDataURL.split(',')[1];
	return  image;
}
