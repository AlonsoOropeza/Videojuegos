public abstract class Pizzeria {
	
	private SimpleFabricaPizza fabricaPizza;
	
	public Pizzeria() {
	     fabricaPizza=new SimpleFabricaPizza();
	}
	
	public abstract Pizza crearPizza(String tipo);
	
	public Pizza ordenarPizza(String tipo) {
		Pizza pizza=null;
		pizza=crearPizza(tipo);
		pizza.preparar();
		pizza.hornear();
		pizza.cortar();
		pizza.empacar();
		return pizza;
	}
	
}