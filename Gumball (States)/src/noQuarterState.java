
public class noQuarterState implements State {

	private GumballMachine gumballMachine;

	public noQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("Please insert a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("There is no quarter to return");
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned but there is not quarter");
	}

	@Override
	public void dispense() {
		System.out.println("We cant dispense you if you havent turned");
	}
}
