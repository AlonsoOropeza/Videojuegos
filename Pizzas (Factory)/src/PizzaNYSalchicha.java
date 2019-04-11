
public class PizzaNYSalchicha extends Pizza {

	public PizzaNYSalchicha() {
		masa="delgada";
		salsa="poca";
		salchicha="poca";
	}
	
	@Override
	public void preparar() {
		System.out.println("Se le pone salchicha");

	}

	@Override
	public void hornear() {
		System.out.println("Se hornea por 40 min");

	}

	@Override
	public void cortar() {
		System.out.println("Se corta en rebanadas");

	}

	@Override
	public void empacar() {
		System.out.println("Se empaca y se pone la etiqueta 'Pizza NY de salchicha'");

	}

}
