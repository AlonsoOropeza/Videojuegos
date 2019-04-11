import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

import image.Animation;
import image.Assets;

// Clase que define el comportamiento del enemigo
public class Medkit extends Chracter{

	// El enemigo tiene una velocidad de rebote
	private int velBounce;
	// Debe de saberse a qué dirección se moverá el enemigo
	private int direction;
	// Ayuda a mantener el tracking de la velocidad del enemigo
	private double vel;
	// Constructor que recibe los atributos de un GameObject, más la velocidad del enemigo
	public Medkit(double x, double y, int width, int height, Color color, BufferedImage imagen, Handler handler, double vel) {
		super(x, y, width, height, color, imagen, handler);
		// El enemigo tiene una velocidad de rebote de -10
		velBounce = -10;
		// Se le asigna una dirección aleatoria entre izquierda (negativo) y derecha (positivo)
		direction = (int) (Math.random() * 100 + 1) > 50? 1: -1;
		this.vel = vel;
		// Se hace que la velocidad en x sea la velocidad que se tiene, en la dirección correspondiente
		velX = vel * direction;
		
		
		}

	// Método encargado de actualizar al enemigo
	@Override
	public void tick() 
	{			
		// Si la velocidad se vuelve menor a 10 se le suma la gravedad para que caiga
		if (velY < 10) velY += gravity;
		// Se detectan las colisiones
		colision();
		
		// Si ha tocado piso
		if (onFloor())
		{
			// Le asigna una dirección aleatoria
			direction = (int) (Math.random() * 100 + 1) > 50? 1: -1;
			// Actualiza la dirección a la que debe moverse
			velX = vel * direction;
		}
		
		// Verifica que no se salga de los límites de la ventana
		if (Game.clampBool(x, 0, Game.width - width - 6)) velX *= -1;
		if (Game.clampBool(y, 0, Game.height - height * 1.9)) velY *= -1;
		
		// Se actualiza la posición del enemigo sumándole las velocidades que tiene a sus respectivos ejes
		x += velX;
		y += velY;
	}

	// Método encargado de detectar las colisiones del enemigo
	@Override
	public void colision() 
	{	
		// Se genera un iterador para verificar todos los objetos contenidos en el Handler
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext())
		{
			// Se genera un objeto auxiliar
			GameObject aux = iterator.next();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(Assets.medkit, getX(), getY(), width, height, null);
	}
	

	
	public double getVel() { return vel; }
	public void setVel(double vel) { this.vel = vel; }

}
