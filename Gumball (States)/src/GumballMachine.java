
public class GumballMachine {
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	
	State state = soldOutState;
	int count=0;
	
	public GumballMachine(int  numberGumballs) {
		this.count = numberGumballs;
		soldOutState = new soldOutState(this);
		noQuarterState = new noQuarterState(this);
		hasQuarterState = new hasQuarterState(this);
		soldState = new soldState(this);
		if(numberGumballs > 0) {
			state = noQuarterState;
		}
	}
	
	public void insertQuarter() {
		state.insertQuarter();
	}
	
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	
	void setState(State state) {
		this.state = state;
	}
	
	void releaseBall() {
		System.out.println("A gumball comes rolling out of the slot");
		if(count != 0) {
			count -= 1;
		}
	}
	
	public int getCount() {
		return count;
	}
	
	public State getnoQuarterState() {
		return noQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}
	
	public State getSoldOutState() {
		return soldOutState;
	}
	
	public State getWinnerState() {
		return winnerState;
	}
	
	public State getHasQuarterState() {
		return hasQuarterState;
	}
}
