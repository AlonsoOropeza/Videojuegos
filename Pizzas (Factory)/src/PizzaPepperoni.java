
public class PizzaPepperoni extends Pizza {

	public PizzaPepperoni() {
		masa=salsa=pepperoni="si";
	}
	
	@Override
	public void preparar() {
		System.out.println("Se le pone pepperoni");

	}

	@Override
	public void hornear() {
		System.out.println("Se hornea por 50 min");

	}

	@Override
	public void cortar() {
		System.out.println("Se corta en triángulos");

	}

	@Override
	public void empacar() {
		System.out.println("Se empaca y se pone la etiqueta 'Pizza de pepperoni'");

	}

}
