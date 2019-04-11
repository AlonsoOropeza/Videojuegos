import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		String tipoPizza;
		Pizza pizza=null;
			
		Pizzeria pizzeriaNY=new PizzeriaTipoNY();
		Pizzeria pizzeriaCH=new PizzeriaTipoChicago();
		
		pizza=pizzeriaNY.ordenarPizza("Queso");
		System.out.println("Aqui esta tu pizza "+pizza.toString());

		pizza=pizzeriaCH.ordenarPizza("Queso");
		System.out.println("Aqui esta tu pizza "+pizza.toString());

	}
}
