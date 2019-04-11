import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

import image.Animation;
import image.Assets;

// Clase que define el comportamiento del jugador
public class Player extends Chracter{
	
	private Animation animLeft;
	private Animation animRight;
	
	// Tiene una velocidad al rebotar
	private int velBounce;
	private int health;

	// Constructor que recibe los atributos de un GameObject
	public Player(double x, double y, int width, int height, Color color, BufferedImage imagen, Handler handler) {
		super(x, y, width, height, color, imagen, handler);
		// La velocidad al rebotar por defecto es de -8
		// Es -8 dado a que al rebotar, la pelota se mueve a arriba (negativo)
		velBounce = -10;
		health = 100;
		
		animLeft = new Animation(100, Assets.marineLeft);
		animRight = new Animation(100, Assets.marineRight);
		}
	
	// Método que nos ayuda a actualizar al jugador
	@Override
	public void tick() 
	{	
		animRight.tick();
		animLeft.tick();
		
		// Si la velocidad en y llega a ser menor a 10, entonces se le resta la gravedad para que caiga
		if (velY < 10) velY += gravity;
		// Se revisan las colisiones
		colision();
		
		// Se revisa que no se salga de los límites de la ventana
		if (Game.clampBool(x, 0, Game.width - width - 6)) velX *= -1;
		if (Game.clampBool(y, 10, Game.height - height * 1.9)) velY *= -1;
		
		// Se actualiza la posición en x y en y con respecto a su velocidad
		x += velX;
		y += velY;
	}
	
	// Método que se encarga de detectar las colisiones
	@Override
	public void colision() 
	{	
		// Se genera un iterador para revisar todos los objetos
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext())
		{
			// Se crea un objeto auxiliar
			GameObject aux = iterator.next();
			// Si el auxiliar es un enemigo
			if (aux instanceof Enemy)
			{
				// Si hace contacto con el enemigo en el eje de las x al sumarle la velocidad
				if (placeMeeting(x+velX, y, aux))
				{
					// Se detecta si va a la derecha o a la izquierda el jugador
					int sign = velX > 0? 1: -1;
					// Mientras aún no esté a un pixel de lejanía
					while(!placeMeeting(x + sign, y, aux))
						// Se acerca de pixel en pixel a la dirección correspondiente
						x += sign;
					// Remueve al objeto porque hizo contacto
					handler.removeObj(aux);
					// Hace que el jugador rebote
					//velX *= -1;				
				}
			}
			if (aux instanceof Killer)
			{
				// Si hace contacto con el enemigo en el eje de las x al sumarle la velocidad
				if (placeMeeting(x+velX, y, aux))
				{
					// Se detecta si va a la derecha o a la izquierda el jugador
					int sign = velX > 0? 1: -1;
					// Mientras aún no esté a un pixel de lejanía
					while(!placeMeeting(x + sign, y, aux))
						// Se acerca de pixel en pixel a la dirección correspondiente
						x += sign;
					// Remueve al objeto porque hizo contacto
					health--;
					if(health<=0) {
						handler.removeObj(this);
						System.exit(1);
					}
				}
			}
			if (aux instanceof Medkit)
			{
				// Si hace contacto con el enemigo en el eje de las x al sumarle la velocidad
				if (placeMeeting(x+velX, y, aux))
				{
					// Se detecta si va a la derecha o a la izquierda el jugador
					int sign = velX > 0? 1: -1;
					// Mientras aún no esté a un pixel de lejanía
					while(!placeMeeting(x + sign, y, aux))
						// Se acerca de pixel en pixel a la dirección correspondiente
						x += sign;
					// Remueve al objeto porque hizo contacto
					handler.removeObj(aux);
					health = 100;
					// Hace que el jugador rebote
					//velX *= -1;				
				}
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), getX(), getY(), width, height, null);
	}
	
	public BufferedImage getCurrentAnimationFrame()
	{
		if (velX > 0) return animRight.getCurrentFrame();
		else return animLeft.getCurrentFrame();
	}

	// Método que lee las teclas que han sido presionadas
	public void keyPressed(int key) {
		// Si es escape, cierra el juego
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
		// Si es la flecha izquierda, vuelve la velocidad en x -3
		if (key == KeyEvent.VK_LEFT) velX = -3;
		// Si es la flecha derecha, vuelve la velocidad en x +3
		if (key == KeyEvent.VK_RIGHT) velX = 3;
	}

	public void keyReleased(int key) {
		
	}

	public void keyTyped(int key) {
		
	}
	
	public int getHealth() { 
		return health; 
	}
}
