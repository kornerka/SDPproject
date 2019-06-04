package com.sdp.smallorder.states;
import java.util.Scanner;

import com.sdp.smallorder.product.Product;

public class UnavailableState implements State{

	@Override
	public int order(Product pd) {
		// TODO Auto-generated method stub
		System.out.println("Produkt niedostêpny. Wys³aæ powiadomienie o dostêpnoœci?");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Wpisz 'tak' lub 'nie'");
		String decision = scanner.nextLine();
		if (decision=="tak"){
			System.out.println("Podaj adres email");
			Scanner email = new Scanner(System.in);
		}
		return 0;	
		
	}
//
//	@Override
//	public void setDeliveryMethod() {
//		// TODO Auto-generated method stub
//		System.out.println("Gdy produkt bêdzie dostêpny, powiadomimy o mo¿liwych sposobach dorêczenia");
//		
//	}

	@Override
	public void next(Product pd) {
		// TODO Auto-generated method stub
		System.out.println("Produkt wycofany ze sprzeda¿y. Mo¿e kiedyœ wznowimy produkcjê;)");
	}

	@Override
	public void prev(Product pd) {
		// TODO Auto-generated method stub
		pd.setState(new OnRequestState());
	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
		
	}

}
