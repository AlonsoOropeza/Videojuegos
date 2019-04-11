
public class soldState implements State {

	private GumballMachine gumballMachine;

	public soldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("Please wait, we are already giving you a gumball");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Sorry you calready turn your crank");
	}

	@Override
	public void turnCrank() {
		System.out.println("Turning twice the cranck wont give you another gumball");
	}

	@Override
	public void dispense() {
		gumballMachine.releaseBall();
		if(gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getnoQuarterState());
		}
		else {
			System.out.println("Oops, out of gumballs");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
}
