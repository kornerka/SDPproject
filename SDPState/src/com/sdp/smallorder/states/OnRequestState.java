package com.sdp.smallorder.states;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.sdp.smallorder.product.Product;

public class OnRequestState implements State{

	@Override
	public int order(Product pd, int onReqAmount) {
		// TODO Auto-generated method stub
//		onReqAmount = 4;
		System.out.println("Wybierz liczbê produktów");
		int am = 0;
		Scanner skaner = new Scanner(System.in);
		try {
		am = skaner.nextInt();
		if (am>onReqAmount){
			System.out.println("Niestety, mo¿na zamówiæ jeszcze tylko "+onReqAmount+" produktów");
			order(pd, onReqAmount);
		}
		else{
			for (int i=1; i<=am; i++) {
				
				System.out.println("Czy chcesz dodaæ modyfikacjê? [tak/nie]");
				Scanner sc = new Scanner(System.in);
				String answ = sc.nextLine();
				if (answ.equals("tak")) {
					System.out.println("Wybierz kolor tkaniny [bia³y/czarny/zielony]");
					String colour = sc.nextLine();
					System.out.println("Wybrany kolor: "+colour);
					System.out.println("Wpisz swój tekst lub zostaw pole puste, jeœli tekst ma byæ domyœlny");
					String text = sc.nextLine();
				}
				else {
					System.out.println("Produkt domyœlny");
				}
			}
		}
		System.out.println("Przewidywany czas dostawy to 2 - 3 tygodnie");
		System.out.println("Podaj dane do dostawy"+"\n");
		System.out.println("Podaj imiê: ");
		String firstname = skaner.nextLine();
		System.out.println("Podaj nazwisko: ");
		String lastname = skaner.nextLine();
		System.out.println("Ulica: ");
		String street = skaner.nextLine();
		System.out.println("Nr domu[/mieszkania]: ");
		String nmb = skaner.nextLine();
		System.out.println("Miasto: ");
		String city = skaner.nextLine();
		System.out.println("Kod pocztowy [xx-xxx]: ");
		String postalcode = skaner.nextLine();
		
		System.out.println("Dane do dostawy: "+firstname+" "+lastname+" "+street+" "+nmb+" "+city+" "+postalcode);
		
		onReqAmount = onReqAmount-am;
//		System.out.println(onReqAmount);
		if (onReqAmount!=0){
			order(pd, onReqAmount);
		}
		else {
			next(pd);
			pd.getState().printStatus();
		}
		
		}
		catch (InputMismatchException e) {
			System.out.println("Podaj liczbê!");
			order(pd, onReqAmount);
		}
		return onReqAmount;
		
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
		System.out.println("Produkt dostêpny na ¿¹danie. Czy chcesz zamówiæ? [tak/nie]");
		Scanner scanner = new Scanner(System.in);
		String ans = scanner.next();
		if (ans.equals("tak")) {
			order(new Product(), 4);
		}
		else {
			
		}
	}

}
