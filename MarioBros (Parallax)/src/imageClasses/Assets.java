package imageClasses;

import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage background;
	public static BufferedImage mario;
	public static void init() {
		background = ImageLoader.loadImage("/images/background.jpg");
		mario = ImageLoader.loadImage("/images/mario.png");
	}
}
