import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

// Clase que define el comportamiento del enemigo
public class Killer extends Chracter{

	// El enemigo tiene una velocidad de rebote
	private int velBounce;
	// Debe de saberse a qu� direcci�n se mover� el enemigo
	private int direction;
	// Ayuda a mantener el tracking de la velocidad del enemigo
	private double vel;
	// Constructor que recibe los atributos de un GameObject, m�s la velocidad del enemigo
	public Killer(double x, double y, int width, int height, Color color, BufferedImage imagen, Handler handler, double vel) {
		super(x, y, width, height, color, imagen, handler);
		// El enemigo tiene una velocidad de rebote de -10
		velBounce = -10;
		// Se le asigna una direcci�n aleatoria entre izquierda (negativo) y derecha (positivo)
		direction = (int) (Math.random() * 100 + 1) > 50? 1: -1;
		this.vel = vel;
		// Se hace que la velocidad en x sea la velocidad que se tiene, en la direcci�n correspondiente
		velX = vel * direction;
		}

	// M�todo encargado de actualizar al enemigo
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
			// Le asigna una direcci�n aleatoria
			direction = (int) (Math.random() * 100 + 1) > 50? 1: -1;
			// Actualiza la direcci�n a la que debe moverse
			velX = vel * direction;
		}
		
		// Verifica que no se salga de los l�mites de la ventana
		if (Game.clampBool(x, 0, Game.width - width - 6)) velX *= -1;
		if (Game.clampBool(y, 0, Game.height - height * 1.9)) velY *= -1;
		
		// Se actualiza la posici�n del enemigo sum�ndole las velocidades que tiene a sus respectivos ejes
		x += velX;
		y += velY;
	}

	// M�todo encargado de detectar las colisiones del enemigo
	@Override
	public void colision() 
	{	
		// Se genera un iterador para verificar todos los objetos contenidos en el Handler
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext())
		{
			// Se genera un objeto auxiliar
			GameObject aux = iterator.next();
			
			// Si el auxiliar es una pared
			if (aux instanceof Wall)
			{
				// Si hace contacto con la pared en el eje de las x al sumarle la velocidad
				if (placeMeeting(x+velX, y, aux))
				{
					// Se detecta si va a la derecha o a la izquierda el enemigo
					int sign = velX > 0? 1: -1;
					// Mientras a�n no est� a un pixel de lejan�a
					while (!placeMeeting(x+sign, y, aux))
						// Se acerca de pixel en pixel a la direcci�n correspondiente
						x+=sign;
					// Hace que la velocidad en x se haga 0 (no rebota)
					velX *= -1;
				}
				// Si hace contacto con la pared en el eje de las y al sumarle la velocidad
				if (placeMeeting(x, y+velY, aux))
				{
					// Se detecta si va arriba o a abajo el enemigo
					int sign = velY > 0? 1: -1;
					// Mientras a�n no est� a un pixel de lejan�a
					while (!placeMeeting(x, y+sign, aux))
						// Se acerca de pixel en pixel a la direcci�n correspondiente
						y+=sign;
					// Hace que la velocidad en x se haga 0 (no rebota)
					velY = 0;
				}
				
				// Si toca piso, entonces rebota
				if (onFloor()) velY = velBounce;
			}
		}
	}
	
	public double getVel() { return vel; }
	public void setVel(double vel) { this.vel = vel; }

}
