import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// Clase que designa el comportamiento de los personajes del juego
public abstract class Chracter extends GameObject{
	
	// Es un juego de plataformas, por lo que tiene gravedad, velocidad en x y en y
	protected double gravity = 0.16, velX;
	protected double velY;
	protected BufferedImage imagen;
	// Constructor que pide los valores del Game object 
	public Chracter(double x, double y, int width, int height, Color color, BufferedImage imagen, Handler handler) {
		super(x, y, width, height, color, handler);
		// Se asigna la velocidad en x a que por defecto sea de 3
		velX = 3;
		this.imagen = imagen;
	}

	// Pinta al personaje
	@Override
	public void paint(Graphics g) 
	{		
		// Se le asigna el color que el personaje tiene
		//g.setColor(color);
		// Los personajes en éste caso son óvalos, así que los dibujamos
		//g.fillOval(getX(),getY(), width, height);
		g.drawImage(imagen, getX(), getY(), width, height, null);
	}

	// Todo personaje tiene un comportamiento diferente, así que el tick sigue siendo abstracto
	public abstract void tick();
	
	// Todos los personajes en éste juego tienen colisión
	public abstract void colision();
	
	// Obtenemos los bordes del personaje
	@Override
	public Rectangle getBounds() 
	{
		return (new Rectangle(getX(), getY(), width, height));
	}
	
	// Place meeting nos ayuda a revisar si el personaje colisiona con otro objeto
	public boolean placeMeeting (double x, double y, GameObject obj)
	{
		// revisa si el rectángulo del otro objeto intersecta con el rectángulo del personaje
		if ((new Rectangle((int)x, (int)y, width, height)).intersects(obj.getBounds())) 
			return true;
		return false;
	}
	
	// Método que nos ayuda a identificar cuando e personaje ha tocado piso
	public boolean onFloor()
	{
		// Para cada objeto contenido en el Handler
		return false;
	}
	
	// A partir de aquí son los setters y getters
	public double getVelX()
	{
		return velX;
	}
	public double getVelY()
	{
		return velY;
	}
	public double getGravity()
	{
		return gravity;
	}
	public void setVelX(double velX)
	{
		this.velX = velX;
	}
	public void setVelY(double velY)
	{
		this.velY = velY;
	}
	public void setGravity(double gravity)
	{
		this.gravity = gravity;
	}
}
