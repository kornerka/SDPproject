package com.sdp.smallorder.states;
import java.util.Scanner;

import com.sdp.smallorder.product.Product;

public class UnavailableState implements State{

	@Override
	public int order(Product pd) {
		// TODO Auto-generated method stub
		System.out.println("Produkt niedost�pny. Wys�a� powiadomienie o dost�pno�ci?");
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
//		System.out.println("Gdy produkt b�dzie dost�pny, powiadomimy o mo�liwych sposobach dor�czenia");
//		
//	}

	@Override
	public void next(Product pd) {
		// TODO Auto-generated method stub
		System.out.println("Produkt wycofany ze sprzeda�y. Mo�e kiedy� wznowimy produkcj�;)");
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
