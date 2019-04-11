public class PizzeriaTipoNY extends Pizzeria {
	@Override
	public Pizza crearPizza(String tipo) {
	Pizza pizza=null;
	    if (tipo.equals("Queso"))
	         pizza=new PizzaNYQueso();
	    else if (tipo.equals("Anchoas"))
	       pizza=new PizzaNYSalchicha();
	    else if(tipo.equals("Vegetariana"))
	          pizza=new PizzaNYVegetariana();
	return pizza;
	}
}
