
public class Main {

	public static void main(String[] args) {
		System.out.println("Creamos un pato de hule");
		RubberDuck rubberDuck = new RubberDuck();
		rubberDuck.makeQuack();
		rubberDuck.makeFly();
		System.out.println("Con el patron strategy su forma de volar le permite: volar!");
		rubberDuck.setHowFly(new Fly());
		rubberDuck.makeFly();
		System.out.println("Creamos un pato de verdad");
		RealDuck realDuck = new RealDuck();
		realDuck.makeQuack();
		realDuck.makeFly();
	}

}
