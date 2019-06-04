package com.sdp.smallorder.states;


import java.util.Scanner;

import com.sdp.smallorder.product.Product;

public class OnRequestState implements State{

	@Override
	public int order(Product pd) {
		// TODO Auto-generated method stub
		int onReqAmount = 4;
		System.out.println("Czy chcesz doda� modyfikacj�? [tak/nie]");
		Scanner sc = new Scanner(System.in);
		String answ = sc.nextLine();
		if (answ.equals("tak")) {
			System.out.println("Wybierz kolor tkaniny [bia�y/czarny/zielony]");
			String colour = sc.nextLine();
			System.out.println("Wybrany kolor: "+colour);
			System.out.println("Wpisz sw�j tekst lub zostaw pole puste, je�li tekst ma by� domy�lny");
			String text = sc.nextLine();
		}
		else {
		
	}
		System.out.println("Przewidywany czas dostawy to 2 - 3 tygodnie");
		System.out.println("Podaj dane do dostawy"+"\n"+"Podaj imi�: ");
		String firstname = sc.nextLine();
		System.out.println("Podaj nazwisko: ");
		String lastname = sc.nextLine();
		
		System.out.println("Ulica: ");
		String street = sc.nextLine();
		System.out.println("Nr domu[/mieszkania]: ");
		String nmb = sc.nextLine();
		System.out.println("Miasto: ");
		String city = sc.nextLine();
		System.out.println("Kod pocztowy [xx-xxx]: ");
		String postalcode = sc.nextLine();
		
		System.out.println("Dane do dostawy: "+firstname+" "+lastname+" "+street+" "+nmb+" "+city+" "+postalcode);
		
		return 3;
	
	}
//
//	@Override
//	public void setDeliveryMethod() {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void next(Product pd) {
		// TODO Auto-generated method stub
		pd.setState(new UnavailableState());
	}

	@Override
	public void prev(Product pd) {
		// TODO Auto-generated method stub
		pd.setState(new AvailableState());
	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
		System.out.println("Produkt dost�pny na ��danie. Czy chcesz zam�wi�? [tak/nie]");
		Scanner scanner = new Scanner(System.in);
		String ans = scanner.next();
		if (ans.equals("tak")) {
			order(new Product());
		}
		else {
			
		}
	}

}
