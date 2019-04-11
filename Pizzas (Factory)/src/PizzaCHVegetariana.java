
public class PizzaCHVegetariana extends Pizza {

	public PizzaCHVegetariana() {
		masa="gruesa";
		salsa="mucha";
		vegetales="poco";
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
		System.out.println("Se sirve como tarta");

	}

	@Override
	public void empacar() {
		System.out.println("Se empaca y se pone la etiqueta 'Pizza CH de vegetales'");

	}

}