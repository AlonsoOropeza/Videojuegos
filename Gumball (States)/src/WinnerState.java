
public class WinnerState implements State{
	
	private GumballMachine gumballMachine;

	public WinnerState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("you cant do this");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("you cant do this");
	}

	@Override
	public void turnCrank() {
		System.out.println("you cant do this");
	}

	@Override
	public void dispense() {
		System.out.println("You are a winner");
		if(gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getnoQuarterState());
		}
		else {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
}
