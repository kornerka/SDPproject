package com.sdp.smallorder.states;
import java.util.Scanner;

import com.sdp.smallorder.product.Product;

public class UnavailableState implements State{

	@Override
	public int order(Product pd, int zero) {
		// TODO Auto-generated method stub
		System.out.println("Produkt niedostêpny. Wys³aæ powiadomienie o dostêpnoœci? [tak/nie]");
		Scanner scanner = new Scanner(System.in);
		String odp = scanner.nextLine();
		if (odp.equals("tak")){
			System.out.println("Podaj adres email");
			String email = scanner.nextLine();
		}
		else{
			System.out.println("Szkoda");
		}
		next(pd);
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
		System.out.println("Dziêkujemy!");
	}

	@Override
	public void prev(Product pd) {
		// TODO Auto-generated method stub
		pd.setState(new OnRequestState());
	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
		System.out.println("Produkt niedostêpny");
		order(new Product(), 0);
		
	}

}
