public class SimpleFabricaPizza {
	public Pizza crearPizza(String tipo) {
	Pizza pizza=null;
	if (tipo.equals("Queso"))
	   pizza=new PizzaQueso();
	else if (tipo.equals("Pepperoni"))
	  pizza=new PizzaPepperoni();
	else if(tipo.equals("Vegetariana"))
	  pizza=new PizzaVegetariana();
	return pizza;
	}
}