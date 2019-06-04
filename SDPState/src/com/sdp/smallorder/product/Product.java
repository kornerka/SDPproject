package com.sdp.smallorder.product;


import com.sdp.smallorder.states.State;
import com.sdp.smallorder.states.AvailableState;

public class Product {
	private State state = new AvailableState();
	
	public void previousState() {
		state.prev(this);
	}
	
	public void nextState() {
		state.next(this);
	}
	
	public void printStatus() {
		state.printStatus();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	
}
