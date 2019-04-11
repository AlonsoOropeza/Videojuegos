
public class soldOutState implements State {

	private GumballMachine gumballMachine;

	public soldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("Out of stock");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Out of stock");	
	}

	@Override
	public void turnCrank() {
		System.out.println("Out of stock");
	}

	@Override
	public void dispense() {
		System.out.println("Out of stock");
	}
}
