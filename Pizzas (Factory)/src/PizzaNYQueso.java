
public class PizzaNYQueso extends Pizza {

	public PizzaNYQueso() {
		masa="delgada";
		salsa="poca";
		queso="mucho";
	}
	
	@Override
	public void preparar() {
		System.out.println("Se le pone queso");

	}

	@Override
	public void hornear() {
		System.out.println("Se hornea por 30 min");

	}

	@Override
	public void cortar() {
		System.out.println("Se corta en rebanadas");

	}

	@Override
	public void empacar() {
		System.out.println("Se empaca y se pone la etiqueta 'Pizza NY de queso'");

	}

}
