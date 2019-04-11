
public class PizzaVegetariana extends Pizza {

	public PizzaVegetariana() {
		masa=salsa=vegetales="si";
	}
	
	@Override
	public void preparar() {
		System.out.println("Se le pone vegetales");

	}

	@Override
	public void hornear() {
		System.out.println("Se hornea por 30 min");

	}

	@Override
	public void cortar() {
		System.out.println("Se corta en círculos");

	}

	@Override
	public void empacar() {
		System.out.println("Se empaca y se pone la etiqueta 'Pizza de vegetales'");

	}

}
