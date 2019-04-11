import java.awt.Color;

import image.Assets;

// Clase encargada de Spawnear enemigos y llevar el control del nivel
public class Spawner {
	// Requiere del Handler para añadirle a los enemigos
	private Handler handler;
	// Variable para llevar la cuenta del nivel
	private int level;
	// Constructor que requiere del Handler
	public Spawner (Handler handler)
	{
		this.handler = handler;
		// Se inicia el juego en el nivel 1
		level = 1;
		// El nivel 1 inicia con un enemigo
		handler.addObj(new Enemy(Math.random() * (Game.width - 50) + 0, 50, 64, 64, null, null, handler, 1));
		
	}
	// Método encargado de actualizar el Spawner
	public void tick()
	{
		// Si no tiene ningún enemigo
		if (!hasEnemy())
		{
			// El nivel de menos tendrá un enemigo
			handler.addObj(new Enemy(Math.random() * (Game.width - 50) + 0, 50, 64, 64, null, null, handler, 1 + level));
			// El nivel incrementa en uno
			level++;
			for (int i = 0; i < level/5; i ++) {
				handler.addObj(new Enemy(Math.random() * (Game.width - 50) + 0, 50, 64, 64, null, null, handler, 1 + level));
			}
			if(level % 5 == 0) {
				handler.addObj(new Medkit(Math.random() * (Game.width - 50) + 0, 50, 64, 64, null, null, handler, 1 + level));
			}
			if(level % 10 == 0) {
				handler.addObj(new Killer(Math.random() * (Game.width - 50) + 0, 50, 128, 128, null, null, handler, 1));
			}
		}
	}
	
	// Método que nos ayuda a saber si ya no existen enemigos en el juego
	public boolean hasEnemy()
	{
		// Por cada objeto se revisa si por lo menos hay un enemigo, si lo hay regresa true
		for (GameObject obj: handler.obj) if (obj instanceof Enemy) return true;
		// Si no se enctontró a lo menos un enemigo, regresa false
		return false;
	}
	
	public int getLevel() { return level; }
}
