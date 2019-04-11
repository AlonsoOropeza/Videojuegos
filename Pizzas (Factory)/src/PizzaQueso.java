
public class PizzaQueso extends Pizza {
	
	public PizzaQueso() {
		masa=salsa=queso="si";
	}
	
	@Override
	public void preparar() {
		System.out.println("Se le pone queso");

	}

	@Override
	public void hornear() {
		System.out.println("Se hornea por 40 min");

	}

	@Override
	public void cortar() {
		System.out.println("Se corta en cuadros");

	}

	@Override
	public void empacar() {
		System.out.println("Se empaca y se pone la etiqueta 'Pizza de queso'");

	}

}
