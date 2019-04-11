
public class RealDuck extends Duck{
		
	private HowFly howFly;
	private HowQuack howQuack;
	
	public RealDuck() {
		howFly = new Fly();
		howQuack = new Quack();
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
