
public class PizzaNYVegetariana extends Pizza {

	public PizzaNYVegetariana() {
		masa="delgada";
		salsa="poca";
		vegetales="mucho";
	}
	
	@Override
	public void preparar() {
		System.out.println("Se le pone vegetales");

	}

	@Override
	public void hornear() {
		System.out.println("Se hornea por 20 min");

	}

	@Override
	public void cortar() {
		System.out.println("Se corta en rebanadas");

	}

	@Override
	public void empacar() {
		System.out.println("Se empaca y se pone la etiqueta 'Pizza NY de vegetales'");

	}

}
