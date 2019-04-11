
public class RubberDuck extends Duck{
		
	private HowFly howFly;
	private HowQuack howQuack;
	
	public RubberDuck() {
		howFly = new NotFly();
		howQuack = new Squeez();
	}
	
	public void setHowFly(HowFly howFly) {
		this.howFly = howFly;
	}
	
	public void setHowQuack(HowQuack howQuack) {
		this.howQuack = howQuack;
	}
	
	public void makeQuack() {
		howQuack.quack();
	}
	public void makeFly() {
		howFly.fly();
	}
}
