
public class Duck {
	
	HowFly howFly;
	HowQuack howQuack;
	
	public Duck() {
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
