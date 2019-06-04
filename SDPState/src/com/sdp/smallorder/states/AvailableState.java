package com.sdp.smallorder.states;

import java.util.Scanner;

import javax.print.attribute.standard.PDLOverrideSupported;

import com.sdp.smallorder.product.Product;


public class AvailableState implements State{
	
	@Override
	public int order(Product pd) {
		// TODO Auto-generated method stub
		int availAmount = 2;
		System.out.println("Dost�pna liczba produkt�w: "+availAmount+"/n"+"Wi�ksze zam�wienia produkujemy na ��danie");
		System.out.println("Wybierz liczb� produkt�w");
		Scanner amount = new Scanner(System.in);
		String am = amount.nextLine();
		if (Integer.parseInt(am)>availAmount) {
			next(pd);
			pd.printStatus();
		}
		else {
			System.out.println("Podaj dane do dostawy"+"\n"+"Podaj imi�: ");
			Scanner sc = new Scanner(System.in);
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
			if (Integer.parseInt(am)==availAmount) {
				next(pd);
				pd.printStatus();
			}
			else {
				System.out.println("Mo�na zam�wi� jeszcze jedn� sztuk� produktu");
				pd.printStatus();
				availAmount--;
				if (Integer.parseInt(am)>availAmount) {
					next(pd);
					pd.printStatus();
				}
			}
		}
		availAmount = availAmount-Integer.parseInt(am);
		return availAmount;

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
		pd.setState(new OnRequestState());
	}

	@Override
	public void prev(Product pd) {
		// TODO Auto-generated method stub
		System.out.println("Produkt mo�na zam�wi�");
	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
		System.out.println("Produkt dost�pny. Czy chcesz zam�wi�? [tak/nie]");
		Scanner scanner = new Scanner(System.in);
		String ans = scanner.nextLine();
		if (ans.equals("tak")) {
			order(new Product());
		}
		else {
			
		}
		
	}

}
