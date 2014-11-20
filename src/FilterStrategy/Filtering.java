package FilterStrategy;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.ImageIcon;

public class Filtering {

	private Reader jsFilter;

	public void setJsFilter(String string) throws IOException {
		this.jsFilter =	Files.newBufferedReader(Paths.get("/home/booob/workspace/GraphicModifier/src/js/" + string), StandardCharsets.UTF_8);
	}
	
	public ImageIcon getImageWithFilter(ImageIcon imgIco) throws ScriptException, NoSuchMethodException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");

		engine.eval(jsFilter);
		
		Invocable inv = (Invocable) engine;

		ImageIcon returnedImage = (ImageIcon) inv.invokeFunction("doFilter", imgIco);
		
		System.err.println(returnedImage.getIconHeight());
		
		imgIco.getImage();
		
		
		return returnedImage;
	}

}
