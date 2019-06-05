package com.sdp.smallorder.states;


import com.sdp.smallorder.product.Product;

public interface State {
	//Product product;
	
	
	public int order(Product pd, int amount);
//  public void setDeliveryMethod();
    void next(Product pd);
    void prev(Product pd);
    void printStatus();
}
