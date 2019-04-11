package image;

// Se importan las librerías a ocupar
import java.awt.image.BufferedImage;

public class Assets {
	
	// Aquí se cargan todas las imágenes que se requieran en el juego
	// Es estático y público dado a que requerimos acceder a ellas desde varias clases
	/*
	 * Ejemplo de BufferedImage con varias imágenes:
	 * public static BufferedImage background, player, cloud, enemy...; 
	*/
	
	public static BufferedImage
		menu,
		medkit,
		background;
	
	public static BufferedImage[]
		marineLeft,
		marineRight,
		cacodemonLeft,
		cacodemonRight,
		demonLeft,
		demonRight;
	
	// En éste método se inicializan todas las imágenes que se van a ocupar
	public static void init()
	{
		// Se hace uso de la clase ImageLoader para cargar la imágen 
		// (la clase debió ser creada previamente)
		
		SpriteSheet marineL = new SpriteSheet(ImageLoader.loadImage("/Textures/marineL.png"));
		SpriteSheet marineR = new SpriteSheet(ImageLoader.loadImage("/Textures/marineR.png"));
		SpriteSheet cacodemonL = new SpriteSheet(ImageLoader.loadImage("/Textures/cacodemonL.png"));
		SpriteSheet cacodemonR = new SpriteSheet(ImageLoader.loadImage("/Textures/cacodemonR.png"));
		SpriteSheet demonL = new SpriteSheet(ImageLoader.loadImage("/Textures/demonL.png"));
		SpriteSheet demonR = new SpriteSheet(ImageLoader.loadImage("/Textures/demonR.png"));
		
		marineLeft = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			marineLeft[i] = marineL.crop(i*192, 0, 192, 192);
		}
		
		marineRight = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			marineRight[i] = marineR.crop(i*192, 0, 192, 192);
		}

		cacodemonLeft = new BufferedImage[2];
		for (int i = 0; i < 2; i ++)
		{
			cacodemonLeft[i] = cacodemonL.crop(i*102, 0, 102, 131);
		}
		
		cacodemonRight = new BufferedImage[2];
		for (int i = 0; i < 2; i ++)
		{
			cacodemonRight[i] = cacodemonR.crop(i*102, 0, 102, 131);
		}
		
		demonLeft = new BufferedImage[2];
		for (int i = 0; i < 2; i ++)
		{
			demonLeft[i] = demonL.crop(i*183, 0, 183, 171);
		}
		
		demonRight = new BufferedImage[2];
		for (int i = 0; i < 2; i ++)
		{
			demonRight[i] = demonR.crop(i*183, 0, 183, 171);
		}
		
		background = ImageLoader.loadImage("/Textures/background.jpg");
		menu = ImageLoader.loadImage("/Textures/menu.jpg");
		medkit = ImageLoader.loadImage("/Textures/medkit.png");
	}
}
