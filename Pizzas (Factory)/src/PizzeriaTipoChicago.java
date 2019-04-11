public class PizzeriaTipoChicago extends Pizzeria {
	@Override
	public Pizza crearPizza(String tipo) {
	Pizza pizza=null;
	    if (tipo.equals("Queso"))
	         pizza=new PizzaCHQueso();
	    else if (tipo.equals("Anchoas"))
	       pizza=new PizzaCHSalchicha();
	    else if(tipo.equals("Vegetariana"))
	          pizza=new PizzaCHVegetariana();
	return pizza;
	}
}
