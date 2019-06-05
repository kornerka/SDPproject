package com.sdp.smallorder.states;
import java.util.Scanner;

import com.sdp.smallorder.product.Product;

public class UnavailableState implements State{

	@Override
	public int order(Product pd, int zero) {
		// TODO Auto-generated method stub
		System.out.println("Produkt niedost�pny. Wys�a� powiadomienie o dost�pno�ci? [tak/nie]");
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
//		System.out.println("Gdy produkt b�dzie dost�pny, powiadomimy o mo�liwych sposobach dor�czenia");
//		
//	}

	@Override
	public void next(Product pd) {
		// TODO Auto-generated method stub
		System.out.println("Dzi�kujemy!");
	}

	@Override
	public void prev(Product pd) {
		// TODO Auto-generated method stub
		pd.setState(new OnRequestState());
	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
		System.out.println("Produkt niedost�pny");
		order(new Product(), 0);
		
	}

}
